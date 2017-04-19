package com.example.daniel.assignment1project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Daniel on 2016-09-05.
 */
public class CustomAdapter extends ArrayAdapter<WeatherForecast>{

    private List<WeatherForecast> items;

    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CustomAdapter(Context context, int resource, List<WeatherForecast> itemsIn) {
        super(context, resource, itemsIn);
        items = itemsIn;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.row, null);
        }

        WeatherForecast item = items.get(position);

        if (item != null) {
            ImageView icon = (ImageView) view.findViewById(R.id.imgIcon);

            TextView forecast = (TextView) view.findViewById(R.id.forecast);
            TextView dateTime = (TextView) view.findViewById(R.id.dateTime);
            TextView temperature = (TextView) view.findViewById(R.id.temperature);
            TextView wind = (TextView) view.findViewById(R.id.wind);
            TextView rain = (TextView) view.findViewById(R.id.rain);

            if (icon != null) {
                switch (item.getWeatherCode()) {
                    case 1:
                        icon.setImageResource(R.mipmap.w01d);
                        break;
                    case 2:
                        icon.setImageResource(R.mipmap.w02d);
                        break;
                    case 3:
                        icon.setImageResource(R.mipmap.w03d);
                        break;
                    case 4:
                        icon.setImageResource(R.mipmap.w04);
                        break;
                    case 5:
                        icon.setImageResource(R.mipmap.w05d);
                        break;
                }

            }
            if (forecast != null) {
                forecast.setText(item.getWeatherName());
            }
            if (dateTime != null) {
                String newDate = item.getStartYYMMDD();
                String newStartTime = item.getStartHHMM();
                String newEndTime = item.getEndHHMM();

                String newTimeDate = newStartTime + "-" + newEndTime + " (" + newDate + ")";
                dateTime.setText(newTimeDate);
            }
            if (temperature != null) {
                temperature.setText(String.valueOf(item.getTemperature()) + ".C");
            }
            if (wind != null) {
                String windDirection = item.getWindDirection();
                String windSpeed = String.valueOf(item.getWindSpeed());

                String windage = windSpeed + " m/s " + windDirection;
                wind.setText(windage);
            }
            if (rain != null) {
                rain.setText(item.getRain() + " mm/h");
            }
        }
        return view;
    }
}
