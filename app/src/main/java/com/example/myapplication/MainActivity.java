package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import chargily.epay.java.*;
import retrofit2.Call;
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

        ChargilyCallback<ChargilyResponse> responseCallback = new ChargilyCallback<>() {

            @Override
            public void onResponse( Call<ChargilyResponse> call, ChargilyResponse response) {
                // do something on response
                if (response.isSuccess()) {
                    response.getStatusCode();
                    response.getCheckoutUrl();
                } else {
                    response.getStatusCode();
                    response.getErrorBody();
                }
            }

            @Override
            public void onFailure( Call<ChargilyResponse> call,  Throwable t) {
                // do something on failure
            }
        };

        client.submitInvoiceAsync(invoice, responseCallback);
    }
}