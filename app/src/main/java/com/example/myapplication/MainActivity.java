package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import chargily.epay.java.*;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ChargilyClient client = new ChargilyClient("api_zqT0BbKCxzIyMvyKSS9rwVRHwwhoqjObtOrLDMciXccujZyHZ18owi8QPsXlUZtj");
        Invoice invoice = new Invoice(
                "Chakhoum Ahmed",
                "rainxh11@gmail.com",
                5.0,
                "https://backend.com/webhook_endpoint",
                "https://frontend.com",
                PaymentMethod.EDAHABIA,
                "5001",
                10000.0);
        try {
            ChargilyResponse response = client.submitInvoice(invoice);
            if (response.isSuccess()) {
                response.getStatusCode();
                response.getCheckoutUrl();
            } else {
                response.getStatusCode();
                response.getErrorBody();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}