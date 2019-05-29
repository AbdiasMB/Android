package com.example.alumno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.alumno.myapplication.models.XPath;

import java.util.ArrayList;

import javax.xml.xpath.XPathConstants;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<XPath> mylist = new ArrayList<>();

        XPath mypath = new XPath(-72.2807908,42.9274099);
        XPath mypath1 = new XPath(-72.2809839,42.9255794);
        XPath mypath2 = new XPath(-72.2791493,42.9248017);
        XPath mypath3 = new XPath(-72.2781086,42.9255559);
        XPath mypath4 = new XPath(-72.2787094,42.9275434);
        XPath mypath5 = new XPath(-72.2807801,42.9274099);

        mylist.add(mypath);
        mylist.add(mypath1);
        mylist.add(mypath2);
        mylist.add(mypath3);
        mylist.add(mypath4);
        mylist.add(mypath5);

        //Por las buenas practicas esto no se hace:"""this,"HAY " + mylist.size() + " elementos""""
        String url = "https://www.keene.edu/campus/maps/tool/?coordinates=";

        String ruta = "";

        //message
        Toast.makeText( this,
                String.format("hay %s elementos",mylist.size()),
                Toast.LENGTH_SHORT).show();

        int i=1;

        for (XPath o :mylist){
            ruta += o.longitud + "%2C%20" + o.latitud;
            if (i < mylist.size()){
                ruta += "%0A";
            }
             i++;
        }
        Log.v("MARBO",url+ruta);

        setContentView(R.layout.activity_main);
    }
}
