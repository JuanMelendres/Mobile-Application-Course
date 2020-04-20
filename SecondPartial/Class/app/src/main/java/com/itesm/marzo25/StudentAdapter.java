package com.itesm.marzo25;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marzo25.R;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView textito1, textito2;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            textito1 = itemView.findViewById(R.id.textView6);
            textito2 = itemView.findViewById(R.id.textView7);
        }
    }

    ArrayList<String> estudiantes;

    public StudentAdapter(ArrayList<String> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return estudiantes.size();
    }

}
