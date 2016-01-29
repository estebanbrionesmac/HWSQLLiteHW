package com.example.admin.sqllitehw;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.sqllitehw.db.beans.*;

import com.example.admin.sqllitehw.db.dbh.*;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ListView contactsListView;
    private ArrayAdapter arrayAdapter;

    private TextView textView ;
    private static final String logref = "EJBM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById( R.id.textView ) ;
        Locale loc = Resources.getSystem().getConfiguration().locale ;
        textView.setText(loc.getDisplayName() +
                        "\n  - Date short : " +
                        DateFormat.getDateInstance( DateFormat.SHORT, loc ).format(new Date()) +
                        "\n  - Date long: " +
                        DateFormat.getDateInstance( DateFormat.LONG, loc ).format( new Date() ) +
                        "\n  - Currency format " + NumberFormat.getCurrencyInstance( loc ).format( 1000.00 )
        );



/*        Log.d(logref, "Inserting data...");
*/
        ContactDBH cdbh = new ContactDBH( this ) ;
/*        //cdbh.addContact(new Contact("Esteban Briones", "+52 1 55 4453 9832", "esteban.brionesmac@gmail.com", 1));
        cdbh.addContact( new Contact ( "Jose Luis", "123456789", "a@b.c", 0 ));
        cdbh.addContact( new Contact ( "Miguel", "756695789", "a@b.c", 0 ));
        cdbh.addContact(new Contact("Antonio", "123898249", "a@b.c", 0));
        cdbh.addContact(new Contact("Jorge", "984156789", "a@b.c", 0));
        cdbh.addContact(new Contact("Taral", "415879636", "a@b.c", 0));
        cdbh.addContact( new Contact ( "Nitin" , "124785199", "a@b.c", 0 ));
*/
        CompanyDBH codbh = new CompanyDBH( this ) ;
/*        codbh.addCompany(new Company("MAC", "www.MobileAppsCompany", 100));
        codbh.addCompany(new Company("IBM", "www.ibm.com", 3000));
        codbh.addCompany(new Company("XXX", "www.3X.com", 555 ));
        codbh.addCompany(new Company("HP", "www.hp.com", 666));
*/
        AddressDBH adbh = new AddressDBH( this ) ;
/*        adbh.addAddress( new Address( "3301 Windy Ridge pkwy", "suite 400", "Atlanta", "Georgia", 30339));
        adbh.addAddress( new Address( "331  Ridge pkwy", "suite 74", "Atlanta", "Georgia", 96741));
        adbh.addAddress( new Address( "01 Windy  pkwy", "suite 14", "Atlanta", "Georgia", 87514));
        adbh.addAddress( new Address( "78 Windy Ridge ", "suite 78", "Atlanta", "Georgia", 32187));

        Log.d("EJBM DB", "<<< ");
*/
        Log.d(logref, "Reading all data...");
        List<Contact> contacts = cdbh.getAllContacts() ;
        List<Company> companies = codbh.getAllCompanies() ;
        List<Address> addresses = adbh.getAllAddresses() ;

        Log.d(logref, "\t Contacts" );
        for ( Contact c : contacts )
            Log.d(logref, "\t\t> " + c );

        Log.d(logref, "\t Companies" );
        for ( Company c : companies )
            Log.d(logref, "\t\t> " + c );

        Log.d(logref, "\t Addresses" );
        for ( Address c : addresses )
            Log.d(logref, "\t\t> " + c );


    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // no more this
//        // setContentView(R.layout.list_fruit);
//
//        ContactDBH cdbh = new ContactDBH( this ) ;
//        setContentView(R.layout.activity_contactlist);
//
//        contactsListView = (ListView) findViewById( R.id.contacts_list );
//
//        // this-The current activity context.
//        // Second param is the resource Id for list layout row item
//        // Third param is input array
//        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cdbh.getAllContacts() );
//        contactsListView.setAdapter(arrayAdapter);
//
//    }

    public void go2ContactList ( View view ) {
        Intent i = new Intent( this, ContactsListActivity.class ) ;
        startActivity( i );
    }

    public void go2CompaniesList ( View view ) {
        Intent i = new Intent( this, CompaniesListActivity.class ) ;
        startActivity( i );
    }

    public void go2AddressesList ( View view ) {

        Intent i = new Intent( this, AddressesListActivity.class ) ;
        startActivity( i );
    }

}
