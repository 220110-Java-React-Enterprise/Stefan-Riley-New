package Repo;

import Persistance.BankAccountModel;
import Utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccountRepo implements DataSourceCRUD<BankAccountModel> {

    //CREATE SECTIONS

    public Integer create(BankAccountModel bankAccountModel) {
        try {
            String sql = "INSERT INTO bank_account (checkingAcctBalance, savingAcctBalance, client_id) VALUES ( ?, ?, ?)";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setDouble(1, bankAccountModel.getCheckingAcctBalance());
            pstmt.setDouble(2, bankAccountModel.getSavingAcctBalance());
            pstmt.setInt(3, bankAccountModel.getClientId());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //READ SECTIONS


    @Override
    public BankAccountModel read(Integer client_id) {
        try {
            String sql = "SELECT * FROM bank_account WHERE client_id = ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, client_id);
            ResultSet rs = pstmt.executeQuery();

            BankAccountModel user = new BankAccountModel();
            if (rs.next()) {
                user.setMainBankAccountNumber(rs.getInt("mainBankAccountNumber"));
                user.setCheckingAcctBalance(rs.getDouble("checkingAcctBalance"));
                user.setSavingAcctBalance(rs.getDouble("savingAcctBalance"));
                user.setClientId(rs.getInt("client_id"));

            } else {
                return null;
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //UPDATE SECTIONS

    public BankAccountModel update(BankAccountModel bankAccountModel) {
        BankAccountModel result = null;
        try {
            String sql = "UPDATE bank_account SET checkingAcctBalance = ?, savingAcctBalance = ? where mainBankAccountNumber= ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setDouble(1, bankAccountModel.getCheckingAcctBalance());
            pstmt.setDouble(2, bankAccountModel.getSavingAcctBalance());
            pstmt.setInt(3, bankAccountModel.getMainBankAccountNumber());

            pstmt.executeUpdate();

            result = bankAccountModel;
        } catch (SQLException e) {

        }
        return result;

    }

    //DELETE SECTIONS

    public void delete(Integer mainBankAccountNumber) {
        try {
            String sql = "DELETE FROM user where mainBankAccountNumber = ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, mainBankAccountNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
