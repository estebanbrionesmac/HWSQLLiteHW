package com.example.admin.sqllitehw;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.sqllitehw.R;
import com.example.admin.sqllitehw.db.dbh.CompanyDBH;
import com.example.admin.sqllitehw.rv.adapters.CompanyAdapter;

/**
 * Created by admin on 1/19/2016.
 */
public class CompaniesListActivity  extends Activity  /* AppCompatActivity */ {

    private ListView companiesListView;
    private ArrayAdapter arrayAdapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no more this
        // setContentView(R.layout.list_fruit);

        CompanyDBH cdbh = new CompanyDBH( this ) ;
        setContentView(R.layout.activity_contactlist );

        //companiesListView = (ListView) findViewById( R.id.rvc );

/*        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cdbh.getAllCompanies() );
        companiesListView.setAdapter(arrayAdapter);
*/

        mRecyclerView = (RecyclerView) findViewById(R.id.rvc );

        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new CompanyAdapter( cdbh.getAllCompanies() );
        mRecyclerView.setAdapter(mAdapter);

    }
}
