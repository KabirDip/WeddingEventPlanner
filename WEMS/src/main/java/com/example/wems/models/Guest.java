
package com.example.wems.models;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Guest {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty("Not Sent");
    public Guest(String name, String email, String phone) {
        this.name.set(name);
        this.email.set(email);
        this.phone.set(phone);
    }
    public StringProperty nameProperty() { return name; }
    public StringProperty emailProperty() { return email; }
    public StringProperty phoneProperty() { return phone; }
    public StringProperty statusProperty() { return status; }
    public String getName() { return name.get(); }
    public String getEmail() { return email.get(); }
    public String getPhone() { return phone.get(); }
    public String getStatus() { return status.get(); }
    public void setStatus(String s) { status.set(s); }
}
