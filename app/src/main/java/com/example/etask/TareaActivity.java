package com.example.etask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.Calendar;

public class TareaActivity extends AppCompatActivity {
    FloatingActionMenu addMenu, deleteMenu;
    FloatingActionButton addQuick, addVoice, addDetailed;
    FloatingActionButton deleteDay, deleteTask;
    FloatingActionButton search;
    ExtendedFloatingActionButton deleteButton;
    Calendar calendar = Calendar.getInstance();
    int year, month, day;
    DatePickerDialog.OnDateSetListener setListener;
    String fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        initViews();
        addEvents();
    }

    private void initViews() {
        addMenu = findViewById(R.id.addMenu);
        deleteMenu = findViewById(R.id.deleteMenu);
        search = findViewById(R.id.search);
        addVoice = findViewById(R.id.addTaskVoice);
        addQuick = findViewById(R.id.addQuickTask);
        addDetailed = findViewById(R.id.addDetailedTask);
        deleteDay = findViewById(R.id.deleteDay);
        deleteTask = findViewById(R.id.deleteTask);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        deleteButton = findViewById(R.id.extendedDelete);
        deleteButton.hide();
    }

    private void addEvents() {

        deleteDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TareaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        addMenu.hideMenu(true);
                        deleteMenu.hideMenu(true);
                        search.hide(true);
                        deleteButton.show();
                        fecha = date;
                    }
                }, year, month,day);
                datePickerDialog.show();

            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWarningDialog();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSearchDialog();


            }
        });

        addQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCreateQuickDialog();
            }
        });

        addVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCreateVoiceDialog();
            }
        });
    }

    private void showCreateVoiceDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(TareaActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(TareaActivity.this).inflate(
                R.layout.fragment_voiceformtask,
                (ConstraintLayout)findViewById(R.id.voiceLayout)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.btnSendVoiceTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        if(alertDialog.getWindow() !=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();
    }

    private void showWarningDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(TareaActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(TareaActivity.this).inflate(
                R.layout.layout_delete_dialog,
                (ConstraintLayout)findViewById(R.id.laoyutDelete)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText("Borrar las tareas del dia " + fecha + "?");
        ((Button) view.findViewById(R.id.button)).setBackgroundColor(Color.parseColor("#0fff95"));

        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                addMenu.showMenu(true);
                deleteMenu.showMenu(true);
                search.show(true);
                deleteButton.hide();
            }
        });
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                addMenu.showMenu(true);
                deleteMenu.showMenu(true);
                search.show(true);
                deleteButton.hide();
            }
        });

        if(alertDialog.getWindow() !=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();
    }

    private void showSearchDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(TareaActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(TareaActivity.this).inflate(
                R.layout.layout_search_bar,
                (ConstraintLayout)findViewById(R.id.barraBuscar)
        );
        builder.setView(view);

        Spinner s = ((Spinner) view.findViewById(R.id.spinnerSearch));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(TareaActivity.this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.imageFilterView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        if(alertDialog.getWindow() !=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();

    }

    private void showCreateQuickDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(TareaActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(TareaActivity.this).inflate(
                R.layout.layout_tarea_rapida,
                (ConstraintLayout)findViewById(R.id.laoyutCreate)
        );
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.crearTareaRapida).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        if(alertDialog.getWindow() !=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();
    }
}