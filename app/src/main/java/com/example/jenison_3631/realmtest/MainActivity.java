package com.example.jenison_3631.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Random random=new Random();
    RecyclerAdapter adapter;
    Realm realm;
    private static long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2, LinearLayoutManager.VERTICAL,false));
        adapter=new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        Realm.init(this);
        Realm.removeDefaultConfiguration();
        RealmConfiguration configuration=new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
        Realm.deleteRealm(configuration);
        realm =Realm.getDefaultInstance();
        RealmResults<AnimalObject> results=realm.where(AnimalObject.class).findAll();
        Log.e("initialdata"," "+results.size());
        results.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<AnimalObject>>() {
            @Override
            public void onChange(RealmResults<AnimalObject> animalObjects, OrderedCollectionChangeSet changeSet) {
                Toast.makeText(MainActivity.this,"started",Toast.LENGTH_SHORT).show();
                Log.e("change triggered"," "+animalObjects.size()+" ");
                Log.e("timediff"," "+(System.currentTimeMillis()-time));
                for (OrderedCollectionChangeSet.Range x:changeSet.getChangeRanges()){
                    adapter.notifyItemRangeChanged(x.startIndex,x.length);
                }
                for (OrderedCollectionChangeSet.Range x:changeSet.getDeletionRanges()){
                    adapter.notifyItemRangeRemoved(x.startIndex,x.length);
                }
                for (OrderedCollectionChangeSet.Range x:changeSet.getInsertionRanges()){
                    adapter.notifyItemRangeInserted(x.startIndex,x.length);
                }
            }
        });
        adapter.setdata(results);
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for(int i=0;i<50000;i++){
                    AnimalObject animalTable=new AnimalObject();
                    animalTable.setAnimalName(i);
                    animalTable.setAnimalType1(random.nextInt());
                    animalTable.setAnimalType2(random.nextInt());
                    animalTable.setAnimalType3(random.nextInt());
                    animalTable.setAnimalType4(random.nextInt());
                    animalTable.setAnimalType5(random.nextInt());
                    animalTable.setAnimalType6(random.nextInt());
                    animalTable.setAnimalType7(random.nextInt());
                    animalTable.setAnimalType8(random.nextInt());
                    animalTable.setAnimalType9(random.nextInt());
                    animalTable.setAnimalType10(random.nextInt());
                    realm.copyToRealmOrUpdate(animalTable);
                }
            }
        });
        findViewById(R.id.loadmore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        time=System.currentTimeMillis();
                        for (int i = 0; i < 50; i++) {
                            int rand = random.nextInt(1000);
                            AnimalObject animalTable = new AnimalObject();
                            animalTable.setAnimalName(rand);
                            animalTable.setAnimalType1(random.nextInt());
                            animalTable.setAnimalType2(random.nextInt());
                            animalTable.setAnimalType3(random.nextInt());
                            animalTable.setAnimalType4(random.nextInt());
                            animalTable.setAnimalType5(random.nextInt());
                            animalTable.setAnimalType6(random.nextInt());
                            animalTable.setAnimalType7(random.nextInt());
                            animalTable.setAnimalType8(random.nextInt());
                            animalTable.setAnimalType9(random.nextInt());
                            animalTable.setAnimalType10(random.nextInt());
                            realm.copyToRealmOrUpdate(animalTable);
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
        Log.e("realm "," "+realm.isClosed());
    }
}
