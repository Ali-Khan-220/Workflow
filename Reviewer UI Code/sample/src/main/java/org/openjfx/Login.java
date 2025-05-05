/*
 * Copyright (c) 2012, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Reviewer Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Text scenetitle = new Text("Welcome, Reviewer");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label applierName = new Label("Applier Name:");
        grid.add(applierName, 0, 1);

        TextField nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Label applierAddress = new Label("Applier Address:");
        grid.add(applierAddress, 0, 2);

        TextField addressTextField = new TextField();
        grid.add(addressTextField, 1, 2);
		
		Label applierEmail = new Label("Applier Email:");
		grid.add(applierEmail, 0, 3);
		
		TextField emailTextField = new TextField();
		grid.add(emailTextField, 1, 3);
		
		Label applierDayOfBirth = new Label("Applier Day of Birth:");
        grid.add(applierDayOfBirth, 0, 4);

        TextField dayOfBirthTextField = new TextField();
        grid.add(dayOfBirthTextField, 1, 4);

        Label applierMonthOfBirth = new Label("Applier Month Of Birth:");
        grid.add(applierMonthOfBirth, 0, 5);

        TextField monthOfBirthTextField = new TextField();
        grid.add(monthOfBirthTextField, 1, 5);
		
		Label applierYearOfBirth = new Label("Applier Year of Birth:");
		grid.add(applierYearOfBirth, 0, 6);
		
		TextField yearOfBirthTextField = new TextField();
		grid.add(yearOfBirthTextField, 1, 6);
		
		Label applierSSN = new Label("Applier SSN");
		grid.add(applierSSN, 0, 7);
		
		TextField ssnTextField = new TextField();
		grid.add(ssnTextField, 1, 7);
		
		Label applierIncome = new Label("Applier Income");
		grid.add(applierIncome, 0, 8);
		
		TextField incomeTextField = new TextField();
		grid.add(incomeTextField, 1, 8);
		
		Label applierEmploymentInformation = new Label("Applier Employment Info");
		grid.add(applierEmploymentInformation, 0, 9);
		
		TextField employmentTextField = new TextField();
		grid.add(employmentTextField, 1, 9);
		
		Label applierFinancialAssets = new Label("Applier Financial Assets");
		grid.add(applierFinancialAssets, 0, 10);
		
		TextField financialAssetsTextField = new TextField();
		grid.add(financialAssetsTextField, 1, 10);
		
		Label applierSupportingDocuments = new Label("Applier Supporting Documents");
		grid.add(applierSupportingDocuments, 0, 11);
		
		TextField supportingDocumentsTextField = new TextField();
		grid.add(supportingDocumentsTextField, 1, 11);
		
		Label immigrantName = new Label("Immigrant Name");
		grid.add(immigrantName, 0, 12);
		
		TextField immigrantNameTextField = new TextField();
		grid.add(immigrantNameTextField, 1, 12);
		
		Label immigrantSSN = new Label("Immigrant SSN");
		grid.add(immigrantSSN, 0, 13);
		
		TextField immigrantSSNTextField = new TextField();
		grid.add(immigrantSSNTextField, 1, 13);
		
		
		
		

        Button btn = new Button("Validate data");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 15);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 17);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Data validated");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
