package com.example.relogio;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;


public class FullscreenActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    private Handler handler = new Handler();
    private Runnable runnable;
    private boolean runnableStopped = false;
    private BroadcastReceiver bateriaReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int nivel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            mViewHolder.tvNivelBateria.setText(String.valueOf(nivel) + "%");
        }
    };
    private boolean cbChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        mViewHolder.tvHorasMinutos = findViewById(R.id.tv_horasMinutos);
        mViewHolder.tvSegundos = findViewById(R.id.tv_segundo);
        mViewHolder.tvNivelBateria = findViewById(R.id.tv_nivelBateria);
        mViewHolder.cbNivelBateria = findViewById(R.id.cb_nivelBateria);
        mViewHolder.llMenu = findViewById(R.id.ll_menu);
        mViewHolder.ivPreferencias = findViewById(R.id.iv_preferencias);
        mViewHolder.ivFechar = findViewById(R.id.iv_fechar);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        registerReceiver(bateriaReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        mViewHolder.cbNivelBateria.setChecked(true);

        mViewHolder.llMenu.animate().translationY(500);

        mViewHolder.ivFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.llMenu.animate().translationY(mViewHolder.llMenu.getMeasuredHeight()).setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
            }
        });

        mViewHolder.ivPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewHolder.llMenu.setVisibility(View.VISIBLE);
                mViewHolder.llMenu.animate().translationY(0).setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
            }
        });

    }

    private void atualizarHora() {
        runnable = new Runnable() {
            @Override
            public void run() {
                if (runnableStopped) {
                    return;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                String horasMinutosFormatados = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE));
                String segundosFormatados = String.format("%02d", calendar.get(Calendar.SECOND));
                mViewHolder.tvHorasMinutos.setText(horasMinutosFormatados);
                mViewHolder.tvSegundos.setText(segundosFormatados);
                long agora = SystemClock.uptimeMillis();
                long proximo = agora + (1000 - (agora % 1000));
                handler.postAtTime(runnable, proximo);
            }
        };
        runnable.run();

        mViewHolder.cbNivelBateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewHolder.cbNivelBateria.isChecked()){
                    mViewHolder.tvNivelBateria.setVisibility(View.VISIBLE);
                }else{
                    mViewHolder.tvNivelBateria.setVisibility(View.GONE);
                }
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        runnableStopped = false;
        atualizarHora();


    }

    @Override
    protected void onStop() {
        super.onStop();
        runnableStopped = true;
    }

    private static class ViewHolder {
        TextView tvHorasMinutos, tvSegundos, tvNivelBateria;
        CheckBox cbNivelBateria;
        ImageView ivPreferencias, ivFechar;
        LinearLayout llMenu;
    }
}

