package com.example.reddit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private ListView lv;
    private TopicAdaptor topicAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        topicAdaptor=new TopicAdaptor(getTopicuri());
        lv=findViewById(R.id.listView);
        lv.setAdapter(topicAdaptor);
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Random rnd=new Random(2);
                int rnd_int=rnd.nextInt();
                if(rnd_int%2==0)
                    topicAdaptor.updateList(getTopicuri());
                else
                    topicAdaptor.updateList(getTopicuri2());
            }
        });

         */

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity3.this,topicAdaptor.getItem(position).toString(),Toast.LENGTH_LONG).show();
                return false;
            }
        });


    }

    private List<Topic> getTopicuri(){
        List<Topic> lst= new ArrayList<>();
        lst.add(new Topic("Animals \uD83D\uDC31"));
        lst.add(new Topic("Anime \uD83E\uDD16"));
        lst.add(new Topic("Art & Design \uD83C\uDFA8"));
        lst.add(new Topic("Beauty \uD83D\uDC84"));
        lst.add(new Topic("Hobbies \uD83D\uDC83"));
        lst.add(new Topic("Entertainment \uD83D\uDCFA"));
        lst.add(new Topic("Fashion \uD83D\uDC56"));
        lst.add(new Topic("Finance & Business \uD83D\uDCB0"));
        lst.add(new Topic("Food \uD83C\uDF54"));
        lst.add(new Topic("Funny \uD83D\uDE02"));
        lst.add(new Topic("Gaming \uD83C\uDFAE"));
        lst.add(new Topic("Health & Lifestyle ❤️"));
        lst.add(new Topic("Music \uD83C\uDFA7"));
        lst.add(new Topic("News \uD83D\uDCF0"));
        lst.add(new Topic("Outdoors \uD83C\uDF32"));
        lst.add(new Topic("Reading & Literature \uD83D\uDCDA"));
        lst.add(new Topic("Relationships \uD83E\uDD1D"));
        lst.add(new Topic("School \uD83C\uDF93"));
        lst.add(new Topic("Science \uD83D\uDD2C"));
        lst.add(new Topic("Sports ⚽"));
        lst.add(new Topic("Technology \uD83D\uDCBB"));
        lst.add(new Topic("Travel & Nature \uD83D\uDEE3"));

        return lst;
    }

    /*private List<Topic> getTopicuri2(){
        List<Topic> lst= new ArrayList<>();
        lst.add(new Topic("model5"));
        lst.add(new Topic("model6"));
        lst.add(new Topic("model7"));
        return lst;
    }
    */
}