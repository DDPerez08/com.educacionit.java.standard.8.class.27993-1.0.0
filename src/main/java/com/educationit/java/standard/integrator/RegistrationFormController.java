
package com.educationit.java.standard.integrator;


import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import com.educationit.java.standard.integrator.model.Customer;
import com.educationit.java.standard.integrator.model.Product;
import com.educationit.java.standard.integrator.service.ICustomer;
import com.educationit.java.standard.integrator.service.IProduct;
import com.educationit.java.standard.integrator.service.impl.CustomerJDBCSupport;
import com.educationit.java.standard.integrator.service.impl.ProductJDBCSupport;
import com.educationit.java.standard.integrator.util.EmailValidator;
import com.educationit.java.standard.integrator.service.impl.MailSenderSupport;


public class RegistrationFormController {


    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    private ICustomer<String, Customer> dao;

    private IProduct<Product> dao2;


    public RegistrationFormController () throws SQLException {

        super ();

        this.dao  = new CustomerJDBCSupport ();

        this.dao2 = new ProductJDBCSupport ();
    }


    @FXML
    protected void handleSubmitButtonAction (ActionEvent event) {

        EmailValidator validator = new EmailValidator ();

        Window owner = submitButton.getScene ().getWindow ();

        if (nameField.getText().isEmpty()) {

            AlertHelper.showAlert (Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            return;
        }

        if (emailField.getText().isEmpty()) {

            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");

            return;
        }

        if (!validator.validateEmail (emailField.getText ())) {

            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email correct");

            return;
        }

        if (passwordField.getText ().isEmpty ()) {

            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        try {

            Customer c = new Customer ();
            c.setEmail (this.emailField.getText ());
            c.setFullName (this.nameField.getText ());
            c.setPassword (Base64.getEncoder ().encodeToString (this.passwordField.getText ().getBytes()));

            this.dao.create(c);

            AlertHelper.showAlert (Alert.AlertType.INFORMATION, owner, "Registration Successful!",
                    "Welcome " + nameField.getText());


            this.emailField.clear ();
            this.nameField.clear ();
            this.passwordField.clear ();

            try {

                List<Product> list = this.dao2.findCreatedToday ();

                if (!list.isEmpty ()) {

                    StringBuilder sb = new StringBuilder ("<b>Dear " + c.getFullName () + "</b>");
                    sb.append ("<br>");
                    sb.append ("<p>These are the product with special price today !!!</p>");
                    sb.append ("<br>");
                    for (Product p: list) {
                        sb.append (".- " + p.getName ());
                        sb.append ("<br>");
                    }
                    sb.append ("<p>Thanks !!!</p>");

                    MailSenderSupport mail = new MailSenderSupport ();
                    mail.sendMail ("info@educacionit.com",
                                    c.getEmail (),
                                    "Product Information",
                            sb.toString ());
                }


            } catch (Exception ex) { ex.printStackTrace (); }

        } catch (Exception e) {

            AlertHelper.showAlert (Alert.AlertType.ERROR, owner, "Registration has problems!",
                    "Try again, sorry");
        }
    }
}