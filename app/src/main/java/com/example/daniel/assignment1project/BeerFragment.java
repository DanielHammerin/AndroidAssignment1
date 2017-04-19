package com.example.daniel.assignment1project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Daniel on 2016-09-07.
 */
public class BeerFragment extends Fragment {

    private static String name = "";
    private static String information = "";
    private static int imageID;
    private static int position;

    private PagerAdapter adapter;

    public static BeerFragment newFragment(int pos, int newImgID, String newName, String newInfo) {
        BeerFragment bf = new BeerFragment();
        Bundle args = new Bundle();
        args.putString("beerName", newName);
        args.putString("beerInfo", newInfo);
        args.putInt("imgId", newImgID);
        args.putInt("position", pos);
        bf.setArguments(args);
        return bf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("beerName");
        information = getArguments().getString("beerInfo");
        imageID = getArguments().getInt("imgId");
        position = getArguments().getInt("position");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.beer_view, container, false);
        TextView beerInfo = (TextView) view.findViewById(R.id.info);
        ImageView beerImage = (ImageView) view.findViewById(R.id.image);
        TextView beerTitle = (TextView) view.findViewById(R.id.beerTitle);

        beerTitle.setText("'" + name + "'" + PagerAdapter.getTitle(position));
        beerInfo.setText(information);
        beerImage.setImageResource(imageID);
        return view;
    }

}
