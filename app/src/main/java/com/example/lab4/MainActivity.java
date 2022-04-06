package com.example.lab4;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import com.example.lab4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMemo();
            }
        });

        binding.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteMemo();
            }
        });

    }

    public void addNewMemo() {
        String memo = binding.memoInput.getText().toString();
        db.addMemo(new Memo(memo));
        updateRecyclerView();
    }
    public void deleteMemo() {
        int memo = parseInt(binding.memoNumber.getText().toString());
        db.deleteMemo(memo);
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());
        binding.output.setHasFixedSize(true);
        binding.output.setLayoutManager(new LinearLayoutManager(this));
        binding.output.setAdapter(adapter);
    }

}