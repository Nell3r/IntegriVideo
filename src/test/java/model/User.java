package model;

public class User {
    String email;
    String password;
    String UrlPhoto;
    String Name;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(){}

    public User(String email, String password, String urlPhoto, String name) {
        this.email = email;
        this.password = password;
        UrlPhoto = urlPhoto;
        Name = name;
    }

    public String getUrlPhoto() {
        return UrlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        UrlPhoto = urlPhoto;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

