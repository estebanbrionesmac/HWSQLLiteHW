package com.example.admin.sqllitehw;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.sqllitehw.db.dbh.*;
import com.example.admin.sqllitehw.db.dbh.ContactDBH ;
import com.example.admin.sqllitehw.rv.adapters.ContactAdapter;

/**
 * Created by admin on 1/17/2016.
 */
public class ContactsListActivity  extends Activity  /* AppCompatActivity */ {

    private ListView contactsListView;
    private ArrayAdapter arrayAdapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        // setContentView(R.layout.list_fruit);

        ContactDBH cdbh = new ContactDBH( this ) ;
        setContentView(R.layout.activity_contactlist);

        //contactsListView = (ListView) findViewById( R.id.rvc );

/*        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cdbh.getAllContacts() );
        contactsListView.setAdapter(arrayAdapter);
*/

        mRecyclerView = (RecyclerView) findViewById(R.id.rvc );

        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new ContactAdapter( cdbh.getAllContacts () );
        mRecyclerView.setAdapter(mAdapter);

    }
}
