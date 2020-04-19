package com.example.interfaceapp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    String list[];
    String cases[];
    String deaths[];
    String recovery[];
    String borders[];
    ListView listView;
    TextView textView;
    TextView desc;
    Button details;
    String activeCountry;
    ImageView flag;
    int cNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        list = getResources().getStringArray(R.array.items);
        cases = getResources().getStringArray(R.array.cases);
        deaths = getResources().getStringArray(R.array.deaths);
        recovery = getResources().getStringArray(R.array.recovered);
        borders = getResources().getStringArray(R.array.borders);
        textView = (TextView)findViewById(R.id.textView);
        desc = (TextView)findViewById(R.id.desc);
        details = (Button)findViewById(R.id.detailsButton);
        flag = (ImageView)findViewById(R.id.flag);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list, R.id.item, list);
        listView.setAdapter(arrayAdapter);

        textView.setText("Corona info app");
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                activeCountry = (String) parent.getItemAtPosition(position);

                if(activeCountry.equals("France")){
                    flag.setImageResource(R.drawable.fr);
                }
                else if(activeCountry.equals("Italy")){
                    flag.setImageResource(R.drawable.it);
                }
                else if(activeCountry.equals("Sweden")){
                    flag.setImageResource(R.drawable.swe);
                }
                else if(activeCountry.equals("UK")){
                    flag.setImageResource(R.drawable.uk);
                }
                else if(activeCountry.equals("USA")){
                    flag.setImageResource(R.drawable.usa);
                }

                flag.setVisibility(View.VISIBLE);
                details.setVisibility(View.VISIBLE);
                desc.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "You selected "+activeCountry, Toast.LENGTH_SHORT).show();

            }
        });

        details.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(activeCountry.equals("France")){
                    cNum = 0;
                    desc.setText("Total cases: "+cases[cNum]+"\nTotal deaths: "+deaths[cNum]+"\nTotal recoveries: "+recovery[cNum]+"\nBorders: "+borders[cNum]);
                }
                else if(activeCountry.equals("Italy")){
                    cNum = 1;
                    desc.setText("Total cases: "+cases[cNum]+"\nTotal deaths: "+deaths[cNum]+"\nTotal recoveries: "+recovery[cNum]+"\nBorders: "+borders[cNum]);
                }
                else if(activeCountry.equals("Sweden")){
                    cNum = 2;
                    desc.setText("Total cases: "+cases[cNum]+"\nTotal deaths: "+deaths[cNum]+"\nTotal recoveries: "+recovery[cNum]+"\nBorders: "+borders[cNum]);
                }
                else if(activeCountry.equals("UK")){
                    cNum = 3;
                    desc.setText("Total cases: "+cases[cNum]+"\nTotal deaths: "+deaths[cNum]+"\nTotal recoveries: "+recovery[cNum]+"\nBorders: "+borders[cNum]);
                }
                else if(activeCountry.equals("USA")){
                    cNum = 4;
                    desc.setText("Total cases: "+cases[cNum]+"\nTotal deaths: "+deaths[cNum]+"\nTotal recoveries: "+recovery[cNum]+"\nBorders: "+borders[cNum]);
                }
                desc.setVisibility(View.VISIBLE);
            }
        });
    }
}
