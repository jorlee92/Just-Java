package com.dant2.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    boolean hasWhippedCreme = false;
    CheckBox whippedCreamCheckBox;
    CheckBox chocolateSyrupCheckBox;
    EditText nameTextBox;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.check_whipped_cream);
        chocolateSyrupCheckBox = (CheckBox) findViewById(R.id.check_chocolate_syrup);
        nameTextBox = (EditText) findViewById(R.id.text_field_name);

    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
    String priceMessage = "Free";
        priceMessage = priceMessage + "\nThank you!";
        hasWhippedCreme = whippedCreamCheckBox.isChecked();
        userName = nameTextBox.getText().toString();
        displayMessage(priceMessage);
    }
    public void decrement(View view){
        if(quantity > 0)
            quantity--;
        display(quantity);
    }
    public void increment(View view) {
        if(quantity < 100)
            quantity++;

        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Hello " + userName + "\n" +  message + "\n Whipped cream = " + hasWhippedCreme + " \n Chocolate Syrup? " + chocolateSyrupCheckBox.isChecked());
        Log.v("Username", userName);
    }


}