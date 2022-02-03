package Persistance;


public class ClientInformationModel {

    //CREATE MENU VARIABLES
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String addressStreet;
    private String addressState;
    private Integer addressZipCode;

    public ClientInformationModel() {

    }

    public ClientInformationModel(Integer id, String username, String password, String firstName, String lastName, String email, String country, String addressStreet, String addressState, Integer addressZipCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.addressStreet = addressStreet;
        this.addressState = addressState;
        this.addressZipCode = addressZipCode;
    }

    public ClientInformationModel(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public ClientInformationModel(String username, String password, String firstName, String lastName, String email, String country, String addressStreet, String addressState, Integer addressZipCode) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.addressStreet = addressStreet;
        this.addressState = addressState;
        this.addressZipCode = addressZipCode;
    }


    //ClientInformationModel GETTER & SETTERS


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public Integer getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(Integer addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public void create(ClientInformationModel newUser) {
    }


}




