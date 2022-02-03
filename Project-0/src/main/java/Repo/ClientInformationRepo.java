package Repo;

import Persistance.ClientInformationModel;
import Utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientInformationRepo implements DataSourceCRUD<ClientInformationModel> {

    //CREATE SECTION

    public Integer create(ClientInformationModel clientInformationModel) {
        try {
            String sql = "INSERT INTO client_information (username, password, firstName, lastName, email, country, addressStreet, addressState, addressZipCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, clientInformationModel.getUsername());
            pstmt.setString(2, clientInformationModel.getPassword());
            pstmt.setString(3, clientInformationModel.getFirstName());
            pstmt.setString(4, clientInformationModel.getLastName());
            pstmt.setString(5, clientInformationModel.getEmail());
            pstmt.setString(6, clientInformationModel.getCountry());
            pstmt.setString(7, clientInformationModel.getAddressStreet());
            pstmt.setString(8, clientInformationModel.getAddressState());
            pstmt.setInt(9, clientInformationModel.getAddressZipCode());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    //READ SECTION

    @Override
    public ClientInformationModel read(Integer id) {
        ClientInformationModel user = new ClientInformationModel(); //THIS IS MARSHALING THE INFORMATION
        try {
            String sql = "SELECT * FROM client_information WHERE client_id = ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("client_id")); //I DON'T NEED TO HANDLE THIS...SO SHOULD IT BE HERE?
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setCountry(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                user.setAddressStreet(rs.getString("addressStreet"));
                user.setAddressState(rs.getString("addressState"));
                user.setAddressZipCode(rs.getInt("addressZipCode"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

    //CREATE SECTION


    public ClientInformationModel update(ClientInformationModel clientInformationModel) {
        ClientInformationModel verifiedUserModel = new ClientInformationModel();
        try {
            String sql = "UPDATE user SET username = ?, password = ?, firstName = ?, lastName = ?, email = ?, country = ?, addressStreet = ?, addressState = ?, addressZipCode = ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(2, clientInformationModel.getUsername());
            pstmt.setString(3, clientInformationModel.getPassword());
            pstmt.setString(4, clientInformationModel.getFirstName());
            pstmt.setString(5, clientInformationModel.getLastName());
            pstmt.setString(6, clientInformationModel.getEmail());
            pstmt.setString(7, clientInformationModel.getCountry());
            pstmt.setString(8, clientInformationModel.getAddressStreet());
            pstmt.setString(9, clientInformationModel.getAddressState());
            pstmt.setInt(10, clientInformationModel.getAddressZipCode());

            pstmt.executeUpdate();
            String verify = "SELECT * FROM user WHERE client_id = ?";
            PreparedStatement vstmt = ConnectionManager.getConnection().prepareStatement(verify);
            pstmt.setInt(1, clientInformationModel.getId());
            ResultSet rs = vstmt.executeQuery();

            while (rs.next()) {

                verifiedUserModel.setUsername(rs.getString("username"));
                verifiedUserModel.setPassword(rs.getString("password"));
                verifiedUserModel.setFirstName(rs.getString("firstName"));
                verifiedUserModel.setLastName(rs.getString("lastName"));
                verifiedUserModel.setEmail(rs.getString("email"));
                verifiedUserModel.setCountry(rs.getString("country"));
                verifiedUserModel.setAddressStreet(rs.getString("addressStreet"));
                verifiedUserModel.setAddressState(rs.getString("addressState"));
                verifiedUserModel.setAddressZipCode(rs.getInt("addressZipCode"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return verifiedUserModel;
    }

    //DELETE SECTION


    @Override
    public void delete(Integer client_id) {
        try {
            String sql = "DELETE FROM user WHERE client_id = ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setInt(1, client_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //AUTHENITCATE SECTIONS


    public ClientInformationModel authenticate(String username, String password) {
        ClientInformationModel user = null;
        try {
            String sql = "SELECT * FROM client_information WHERE username = ? AND password = ?";
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            user = new ClientInformationModel();
            while (rs.next()) {

                user.setId(rs.getInt("client_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setCountry(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                user.setAddressStreet(rs.getString("addressStreet"));
                user.setAddressState(rs.getString("addressState"));
                user.setAddressZipCode(rs.getInt("addressZipCode"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}


