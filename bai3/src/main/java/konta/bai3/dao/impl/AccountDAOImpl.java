package konta.bai3.dao.impl;

import konta.bai3.dao.AccountDAO;
import konta.bai3.db.DatabaseUtility;
import konta.bai3.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<Account>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from account");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setId(rs.getInt("acc_id"));
                a.setUsername(rs.getString("user_name"));
                a.setPassword(rs.getString("password"));
                a.setPermission(rs.getBoolean("permission"));
                a.setStatus(rs.getBoolean("acc_status"));

                list.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtility.closeConnection(con);
        }
        return list;
    }

    @Override
    public Account findById(Integer id) {
        Account u = null;

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("select * from account where acc_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                u = new Account();
                u.setId(rs.getInt("acc_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setPermission(rs.getBoolean("permission"));
                u.setStatus(rs.getBoolean("acc_status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtility.closeConnection(con);
        }

        return u;
    }

    @Override
    public boolean add(Account account) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("insert into account(user_name,password,permission,acc_status) values (?,?,?,?)");
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            pstmt.setBoolean(3, account.getPermission());
            pstmt.setBoolean(4, account.getStatus());

            int i = pstmt.executeUpdate();
            if (i > 0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean edit(Account account) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("update account set user_name=?,password=?,permission=?,acc_status=? where acc_id=?");
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            pstmt.setBoolean(3, account.getPermission());
            pstmt.setBoolean(4, account.getStatus());

            pstmt.setInt(5, account.getId());

            int i = pstmt.executeUpdate();
            if (i > 0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean delete(Integer id) {
        boolean bl = false;

        Connection con;
        PreparedStatement pstmt;

        con = DatabaseUtility.getConnection();
        try {
            pstmt = con.prepareStatement("delete from account where acc_id=?");
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0)
                bl = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public List<Account> findByUserName(String name) {
        List<Account> list = new ArrayList<>();

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        con = DatabaseUtility.getConnection();
        try {
            if (name == null || name.isEmpty())
                name = "%";
            else
                name = "%" + name + "%";
            pstmt = con.prepareStatement("select * from account where user_name like ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Account u = new Account();
                u.setId(rs.getInt("acc_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setPermission(rs.getBoolean("permission"));
                u.setStatus(rs.getBoolean("acc_status"));
                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtility.closeConnection(con);
        }

        return list;
    }
}
