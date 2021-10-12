package com.pucmm.parcial1temasespeciales;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pucmm.parcial1temasespeciales.placeholder.PlaceholderContent;

import org.w3c.dom.Text;


public class ItemDetailFragment extends Fragment {

    private PlaceholderContent.PlaceholderVersion element;

    public ItemDetailFragment(){    }

    public static ItemDetailFragment newInstance(PlaceholderContent.PlaceholderVersion element) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
       args.putSerializable("element", element);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            element = (PlaceholderContent.PlaceholderVersion) getArguments().getSerializable("element");
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        TextView details = view.findViewById(R.id.details);
        TextView internalCode = view.findViewById(R.id.internalCodeTV);
        TextView version = view.findViewById(R.id.versionTextView);
        TextView date = view.findViewById(R.id.dateTextview);
        CheckBox support = view.findViewById(R.id.supportCheckBox);
        Button link = view.findViewById(R.id.linkButton);

        details.setText(element.getDetails());
        internalCode.setText(element.getInternalCodeName());
        version.setText(element.getVersionNumber());
        date.setText(element.getReleaseDate().toString());
        if(element.isSupported()){
            support.setChecked(true);
            support.setEnabled(false);
        }else{
            support.setChecked(false);
            support.setEnabled(false);
        }


        link.setOnClickListener(v ->{
            Uri uri = Uri.parse(element.getLink());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        return view;
    }

}
