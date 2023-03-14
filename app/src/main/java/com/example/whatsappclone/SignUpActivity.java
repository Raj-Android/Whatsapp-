package com.example.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappclone.Model.User;
import com.example.whatsappclone.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();         // Hide action bar

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog=new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account please wait..");

       binding.btnSignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               progressDialog.show();
               mAuth.createUserWithEmailAndPassword(binding.edtEmail.getText().toString(),binding.edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       progressDialog.dismiss();
                   if (task.isSuccessful()){//if user login successful show a toast
                       User user=new User(binding.edtUserName.getText().toString(),binding.edtEmail.getText().toString(),binding.edtPassword.getText().toString());

                       String id=task.getResult().getUser().getUid();
                       database.getReference().child("Users from manualy").child(id).setValue(user);

                       Toast.makeText(SignUpActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                   }
                   else{  //if user do not able to signUp with any reason (exception) show that exception message
                       Toast.makeText(SignUpActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                   }
               });

           }
       });
       binding.txtAlreadyAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
               startActivity(intent);
           }
       });




    }
}