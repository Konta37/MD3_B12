package konta.bai3.controller;

import konta.bai3.dao.impl.AccountDAOImpl;
import konta.bai3.entity.Account;
import konta.bai3.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadAccount", value = "/LoadAccount")
public class LoadAccount extends HttpServlet {
    private AccountDAOImpl accountDAO = new AccountDAOImpl();
    private AccountServiceImpl accountService = new AccountServiceImpl();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteAccount(request,response);
                break;
            case "details":
                showDetail(request,response);
                break;
            case "search":
                searchAccounts(request,response);
                break;
            default:
                listAccounts(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "save":
                saveAccount(request,response);
                break;
            case "update":
                updateAccount(request,response);
                break;
            default:
                listAccounts(request,response);
                break;
        }
    }

    private void listAccounts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("accounts", accountDAO.findAll());
        request.getRequestDispatcher("/views/account/account-list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/account/account-form.jsp").forward(request,response);
    }

    private void saveAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        String status = request.getParameter("status");

        Boolean accountPermission = true;
        Boolean accountStatus = true;

        if (permission == null) accountPermission = false;
        if (status == null) accountStatus = false;

        Account account = new Account(1,username, password, accountPermission, accountStatus);

        accountService.add(account);

        response.sendRedirect("LoadAccount");

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account existAccount = accountService.findById(id);
        request.setAttribute("account", existAccount);
        request.getRequestDispatcher("views/account/account-form.jsp").forward(request,response);
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        String status = request.getParameter("status");

        Boolean accountPermission = true;
        Boolean accountStatus = true;

        if (permission == null) accountPermission = false;
        if (status == null) accountStatus = false;

        Account account = new Account(id, username, password, accountPermission, accountStatus);
        accountService.edit(account);

        response.sendRedirect("LoadAccount");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        accountService.delete(id);
        response.sendRedirect("LoadAccount");
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = accountService.findById(id);

        request.setAttribute("account", account);
        request.getRequestDispatcher("views/account/account-details.jsp").forward(request, response);
    }

    private void searchAccounts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String searchQuery = request.getParameter("searchQuery");
        List<Account> searchResults = accountService.findByUserName(searchQuery);

        request.setAttribute("accounts", searchResults);
        request.getRequestDispatcher("views/account/account-list.jsp").forward(request, response);
    }

    public void destroy() {
    }
}