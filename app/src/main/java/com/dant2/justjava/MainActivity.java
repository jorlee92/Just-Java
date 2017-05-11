package com.dant2.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.check_whipped_cream);
        chocolateSyrupCheckBox = (CheckBox) findViewById(R.id.check_chocolate_syrup);
    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
    String priceMessage = "Free";
        priceMessage = priceMessage + "\nThank you!";
        hasWhippedCreme = whippedCreamCheckBox.isChecked();
        displayMessage(priceMessage);
    }
    public void decrement(View view){
        quantity--;
        display(quantity);
    }
    public void increment(View view) {
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
        priceTextView.setText(message + "\n Whipped cream = " + hasWhippedCreme + " \n Chocolate Syrup? " + chocolateSyrupCheckBox.isChecked());
    }


}