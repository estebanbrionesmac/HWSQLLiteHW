package com.example.admin.sqllitehw.rv.adapters;

import com.example.admin.sqllitehw.*  ;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.admin.sqllitehw.db.beans.Contact;

import java.util.ArrayList;


public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContactAdapter (ArrayList<Contact> myDataset) {
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
            id = (TextView) v.findViewById( R.id.contact_id);
            //coid = (TextView) v.findViewById( R.id.contact_coid);
            name = (TextView) v.findViewById( R.id.contact_name);
            //phone = (TextView) v.findViewById( R.id.contact_phone);
            //mail = (TextView) v.findViewById( R.id.contact_email);
        }
    }

    public void add(int position, Contact c /* String item*/ ) {
        mDataset.add(position, c /* item*/);
        notifyItemInserted(position);
    }

    public void remove(Contact c /*String item*/) {
        int position = mDataset.indexOf( c /* item*/ );
        if ( position < 0 )
            return ;

        mDataset.remove(position);
        notifyItemRemoved(position);
    }



    // Create new views (invoked by the layout manager)
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Contact /* String */ contact = mDataset.get(position);

        holder.id.setText( "[" + contact.getID() + "]  " + contact.getName() /* mDataset.get(position) */);
//        holder.coid.setText( contact.getCompanyID () );
        holder.name.setText( /*contact.getName() */ contact.getPhoneNumber() + "\t\t " + contact.getEmail() );
        //holder.phone.setText( contact.getPhoneNumber() );
        //holder.mail.setText( contact.getEmail() );

        holder.id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                remove(contact);
            }

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
