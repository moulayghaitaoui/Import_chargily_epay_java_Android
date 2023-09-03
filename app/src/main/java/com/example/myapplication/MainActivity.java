package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import chargily.epay.java.*;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

try {
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
        public void onResponse(Call call, ChargilyResponse chargilyResponse) {
            if (chargilyResponse.isSuccess()) {
                chargilyResponse.getStatusCode();
                chargilyResponse.getCheckoutUrl();
            } else {
                chargilyResponse.getStatusCode();
                chargilyResponse.getErrorBody();
            }
        }

        @Override
        public void onFailure(Call call, Throwable throwable) {

        }



    };

    client.submitInvoiceAsync(invoice, responseCallback);

}catch (Exception e){
    System.out.println(e.getMessage().toString());
}
          }
}