package com.example.admin.sqllitehw.rv.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.sqllitehw.R;
import com.example.admin.sqllitehw.db.beans.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 1/19/2016.
 */
public class CompanyAdapter  extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private List<Company> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CompanyAdapter ( List<Company> myDataset) {
        mDataset = myDataset;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView id;
        public TextView coid;
        public TextView name;
        public TextView phone;
        public TextView mail;


        public ViewHolder(View v) {
            super(v);
            id = (TextView) v.findViewById( R.id.company_id);
            //coid = (TextView) v.findViewById( R.id.company_coid);
            name = (TextView) v.findViewById( R.id.company_name);
            //phone = (TextView) v.findViewById( R.id.company_phone);
            //mail = (TextView) v.findViewById( R.id.company_email);
        }
    }

    public void add(int position, Company c /* String item*/ ) {
        mDataset.add(position, c /* item*/);
        notifyItemInserted(position);
    }

    public void remove(Company c /*String item*/) {
        int position = mDataset.indexOf( c /* item*/ );
        if ( position < 0 )
            return ;

        mDataset.remove(position);
        notifyItemRemoved(position);
    }



    // Create new views (invoked by the layout manager)
    @Override
    public CompanyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.company, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Company /* String */ company = mDataset.get(position);

        holder.id.setText( "[" + company.getID() + "]  " + company.getName() /* mDataset.get(position) */);
//        holder.coid.setText( company.getCompanyID () );
        holder.name.setText( /*company.getName() */ company.getUrl() + "\t\t " + company.getEmployees() );
        //holder.phone.setText( company.getPhoneNumber() );
        //holder.mail.setText( company.getEmail() );

        holder.id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                remove(company);
            }

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
