package com.example.quiz.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.models.Quiz;
import com.example.quiz.utils.ColorPicker;
import com.example.quiz.utils.IconPicker;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder>  {
    Context context;
    List<Quiz> quizzes;

    public QuizAdapter(Context context, List<Quiz> quizzes) {
        this.context = context;
        this.quizzes = quizzes;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent,false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.textViewTitle.setText(quizzes.get(position).getTitle());
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker.getInstance().getColor()));
        holder.iconView.setImageResource(IconPicker.getInstance().getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,quizzes.get(position).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    /////// Inner class

    public class QuizViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView textViewTitle;
        ImageView iconView;
        CardView cardContainer;


        public QuizViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textViewTitle = itemView.findViewById(R.id.QuizTitle);
            iconView = itemView.findViewById(R.id.quizIcon);
            cardContainer = itemView.findViewById(R.id.cardContainer);
        }


    }

}
