package com.example.systemtest;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initHideStatusBar();

        View myListView = findViewById(R.id.myList);
        RecyclerView rvPreviews = findViewById(R.id.rvPreviews);
        ImageView ivList = myListView.findViewById(R.id.ivImage);
        TextView tvList = myListView.findViewById(R.id.tvImageInfo);

        View myInfoView = findViewById(R.id.info);
        ImageView ivInfo = myInfoView.findViewById(R.id.ivImage);
        TextView tvInfo = myInfoView.findViewById(R.id.tvImageInfo);

        ivList.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_plus,null));
        ivInfo.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_info,null));
        tvList.setText(getString(R.string.my_list));
        tvInfo.setText(getString(R.string.info));

        AdapterCircularMovies adapter = new AdapterCircularMovies(this);
        rvPreviews.setAdapter(adapter);
    }

    private void initHideStatusBar(){
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
/*
 <androidx.constraintlayout.widget.ConstraintLayout
                    android:id="@+id/layoutAction"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <include
                        android:id="@+id/myList"
                        layout="@layout/layout_play_button"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        app:layout_constraintEnd_toStartOf="@id/playButton"
                        app:layout_constraintStart_toStartOf="parent" />

                    <LinearLayout
                        android:id="@+id/playButton"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:background="@drawable/button_bg"
                        android:gravity="center"
                        android:orientation="horizontal"
                        android:padding="@dimen/normal_padding"
                        app:layout_constraintBottom_toBottomOf="parent"
                        app:layout_constraintEnd_toEndOf="parent"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toTopOf="parent">

                        <ImageView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:contentDescription="@null"
                            android:src="@drawable/ic_play_black" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="@dimen/small_margin"
                            android:fontFamily="@font/sans_semi_bold"
                            android:text="@string/play"
                            android:textColor="@android:color/black"
                            android:textSize="@dimen/heading_text_size" />

                    </LinearLayout>

                    <include
                        android:id="@+id/info"
                        layout="@layout/layout_play_button"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        app:layout_constraintEnd_toEndOf="parent"
                        app:layout_constraintStart_toEndOf="@id/playButton" />

                </androidx.constraintlayout.widget.ConstraintLayout>

                <TextView
                    android:id="@+id/tvPreviews"
                    style="@style/HeadStyleTextView"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginStart="@dimen/small_margin"
                    android:layout_marginTop="@dimen/medium_margin"
                    android:text="Previews"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@id/layoutAction" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rvPreviews"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
                    app:layout_constraintTop_toBottomOf="@id/tvPreviews"
                    tools:listitem="@layout/layout_circle" />

                <include
                    android:id="@+id/layoutPlay"
                    layout="@layout/layout_play"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:layout_constraintTop_toBottomOf="@id/rvPreviews" />

                <include
                    android:id="@+id/layoutSuggestion"
                    layout="@layout/layout_suggestions"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:layout_constraintTop_toBottomOf="@id/layoutPlay" />
 */