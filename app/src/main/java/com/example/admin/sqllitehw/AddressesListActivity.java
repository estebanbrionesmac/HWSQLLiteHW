package com.example.admin.sqllitehw;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.sqllitehw.db.dbh.AddressDBH;
import com.example.admin.sqllitehw.rv.adapters.AddressAdapter;

/**
 * Created by admin on 1/19/2016.
 */
public class AddressesListActivity extends Activity  /* AppCompatActivity */ {

    private ListView addressesListView;
    private ArrayAdapter arrayAdapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        // setContentView(R.layout.list_fruit);

        AddressDBH cdbh = new AddressDBH(this);
        setContentView(R.layout.activity_contactlist);

        //addressesListView = (ListView) findViewById( R.id.rvc );

/*        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cdbh.getAlladdressies() );
        addressesListView.setAdapter(arrayAdapter);
*/

        mRecyclerView = (RecyclerView) findViewById(R.id.rvc);

        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new AddressAdapter(cdbh.getAllAddresses());
        mRecyclerView.setAdapter(mAdapter);

    }
}