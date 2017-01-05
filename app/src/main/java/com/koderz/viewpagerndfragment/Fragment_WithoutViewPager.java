package com.koderz.viewpagerndfragment;




import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment_WithoutViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_without_view_pager);


        Button btn1= (Button) findViewById(R.id.btnOne);
        Button btn2= (Button) findViewById(R.id.btnTwo);

        final int contentFrame=R.id.contentFrame;

        getSupportFragmentManager()
                .beginTransaction()
                .add(contentFrame,new Fragment2())
                .commit();



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Fragment1 fragment1=new Fragment1();
                fragmentTransaction.replace(contentFrame,fragment1);
                fragmentTransaction.commit();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(contentFrame,new Fragment2())
                        .commit();

            }
        });

    }
}
