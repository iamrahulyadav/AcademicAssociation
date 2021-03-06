package app.tutor.com.tutorapps.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.LinkedList;

import app.tutor.com.tutorapps.R;
import app.tutor.com.tutorapps.customview.RobotoBold;
import app.tutor.com.tutorapps.pojo.QuestionAnsModel;

/**
 * Created by Saikat's Mac on 11/06/16.
 */
public class CorrectAnswerAdapter extends RecyclerView.Adapter<CorrectAnswerAdapter.ViewHolder> {

    LinkedList<QuestionAnsModel> subName;
    Context mContext = null;
    private LayoutInflater inflater = null;

    public CorrectAnswerAdapter(Context mContext, LinkedList<QuestionAnsModel> subName) {
        super();
        this.subName = subName;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }


    public LinkedList<QuestionAnsModel> getSubName() {
        return subName;
    }


    @Override
    public int getItemViewType(int position) {
        return subName.get(position).getViewType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new ViewHolder(inflater.inflate(R.layout.items_question_ans_paragraph, parent, false), viewType);
        } else {
            return new ViewHolder(inflater.inflate(R.layout.items_question_ans, parent, false), viewType);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        try {


            holder.subText.setText((position + 1) + ". " + Html.fromHtml(subName.get(position).getQuestion()));


            if (subName.get(position).getParagraph().equals("")) {
                holder.seperater.setVisibility(View.VISIBLE);
            } else {
                if (subName.get(position).getViewType() == 1) {
                    holder.paragraph.setText(subName.get(position).getParagraph());
                    holder.seperater.setVisibility(View.VISIBLE);
                } else {
                    holder.seperater.setVisibility(View.GONE);
                }
            }

            if (position == 0) {
                holder.seperater.setVisibility(View.GONE);
            }

            holder.option1.setText(subName.get(position).getOption1());
            holder.option2.setText(subName.get(position).getOption2());
            holder.option3.setText(subName.get(position).getOption3());
            holder.option4.setText(subName.get(position).getOption4());


            holder.option1.setEnabled(false);
            holder.option2.setEnabled(false);
            holder.option3.setEnabled(false);
            holder.option4.setEnabled(false);

            holder.option1.setChecked(false);
            holder.option2.setChecked(false);
            holder.option3.setChecked(false);
            holder.option4.setChecked(false);

            holder.option1.setTextColor(Color.BLACK);
            holder.option2.setTextColor(Color.BLACK);
            holder.option3.setTextColor(Color.BLACK);
            holder.option4.setTextColor(Color.BLACK);


            if (subName.get(position).getYourAns() == 1) {
                holder.option1.setChecked(true);
                holder.option1.setTextColor(Color.RED);
            } else if (subName.get(position).getYourAns() == 2) {
                holder.option2.setChecked(true);
                holder.option2.setTextColor(Color.RED);
            } else if (subName.get(position).getYourAns() == 3) {
                holder.option3.setChecked(true);
                holder.option3.setTextColor(Color.RED);
            } else if (subName.get(position).getYourAns() == 4) {
                holder.option4.setChecked(true);
                holder.option4.setTextColor(Color.RED);
            }



            if (subName.get(position).getCorrectAns() == 1) {
                holder.option1.setTextColor(Color.parseColor("#558B2F"));
            } else if (subName.get(position).getCorrectAns() == 2) {
                holder.option2.setTextColor(Color.parseColor("#558B2F"));
            } else if (subName.get(position).getCorrectAns() == 3) {
                holder.option3.setTextColor(Color.parseColor("#558B2F"));
            } else if (subName.get(position).getCorrectAns() == 4) {
                holder.option4.setTextColor(Color.parseColor("#558B2F"));
            }

            // Logger.showMessage("ansselected", "Correct : " + subName.get(position).getCorrectAns() + " position :" + position);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return subName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        RobotoBold subText = null;
        RobotoBold paragraph = null;
        RadioButton option1, option2, option3, option4;
        View seperater = null;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            seperater = itemView.findViewById(R.id.seperator);
            if (viewType == 1) {
                paragraph = (RobotoBold) itemView.findViewById(R.id.paragraph);
            }
            subText = (RobotoBold) itemView.findViewById(R.id.question);

            option1 = (RadioButton) itemView.findViewById(R.id.option_one);
            option2 = (RadioButton) itemView.findViewById(R.id.option_two);
            option3 = (RadioButton) itemView.findViewById(R.id.option_three);
            option4 = (RadioButton) itemView.findViewById(R.id.option_four);

        }

    }
}
