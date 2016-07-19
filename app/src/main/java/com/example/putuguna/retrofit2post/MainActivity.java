package com.example.putuguna.retrofit2post;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.putuguna.retrofit2post.apis.ApiClient;
import com.example.putuguna.retrofit2post.apis.ApiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ExpandAdapter adapter;
    private ExpandableListView expandableListView;
    private List<FaqModel> listFaqHeader;
    private HashMap<FaqModel, FaqModel> listFaqChild;
    private Button btnLogin;
    private EditText username;
    private EditText password;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.list);
        btnLogin = (Button) findViewById(R.id.btn_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Get My FAQ");
                progressDialog.setMessage("Loading ...");
                progressDialog.show();

                prepareData();

            }
        });
    }

    private void prepareData(){
        listFaqHeader = new ArrayList<>();
        listFaqChild = new HashMap<>();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListFaqModel> call = apiService.postLogin(username.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<ListFaqModel>() {
            @Override
            public void onResponse(Call<ListFaqModel> call, Response<ListFaqModel> response) {
                List<FaqModel> list = response.body().getPertanyaan();
                listFaqHeader = list;
                Log.d("TAG", "VALUE SIZE : " + list.size());
                for(int i=0; i<list.size(); i++){
                    Log.d("TAG", "VALUE : " + list.get(i).getQuestion());
                    listFaqChild.put(listFaqHeader.get(i),list.get(i));
                    adapter = new ExpandAdapter(MainActivity.this,listFaqHeader,listFaqChild);
                    expandableListView.setAdapter(adapter);
                }

                progressDialog.dismiss();
                username.setText("");
                password.setText("");

            }

            @Override
            public void onFailure(Call<ListFaqModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_LONG).show();
            }
        });
    }
}
