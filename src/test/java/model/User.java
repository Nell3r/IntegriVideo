package model;

public class User {
    String email;
    String password;
    String urlPhoto;
    String name;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(){}

    public User(String email, String password, String urlPhoto, String name) {
        this.email = email;
        this.password = password;
        this.urlPhoto = urlPhoto;
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        urlPhoto = urlPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

