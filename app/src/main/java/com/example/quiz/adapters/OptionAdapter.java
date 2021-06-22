package com.example.quiz.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.models.Questions;

import java.util.Arrays;
import java.util.List;

//@RequiresApi(api = Build.VERSION_CODES.R)
public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionViewHolder> {
    Context context;
    Questions question;

    public OptionAdapter(Context context, Questions question) {
        this.context = context;
        this.question = question;
    }

    List<String> options = Arrays.asList(question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());

    public class OptionViewHolder extends RecyclerView.ViewHolder{

        View itemview,optionView;
        public OptionViewHolder(View itemView) {
            super(itemView);
            this.itemview = itemview;
            optionView = itemview.findViewById(R.id.quiz_option);
        }
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.option_item, parent, false);
        return new OptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
        holder.optionView.setVisibility(Integer.parseInt(options.get(position)));
    }

    @Override
    public int getItemCount() {
        return options.size();
    }


    //inner Class



}
