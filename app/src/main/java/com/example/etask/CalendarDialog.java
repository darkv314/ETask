package com.example.etask;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CalendarDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Obtener fecha actual
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Retornar en nueva instancia del dialogo selector de fecha
        return new DatePickerDialog(
                getActivity(),
                (DatePickerDialog.OnDateSetListener) getActivity(),
                year,
                month,
                day);
    }

}
