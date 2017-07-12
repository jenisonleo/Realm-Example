package com.example.jenison_3631.realmtest;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jenison-3631 on 14/06/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<AnimalObject> list=new ArrayList<>();
    Random random=new Random();
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textview=new TextView(parent.getContext());
        textview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));
        return new ViewHolder(textview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(Color.argb(random.nextInt(255),random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        ((TextView)holder.itemView).setText(list.get(position).getAnimalName()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    public void setdata(List<AnimalObject> list){
        this.list=list;
    }

//    public void addData(final List<AnimalTable> data){
//        if (list.size()==0) {
//            if(data!=null) {
//                list = data;
//                notifyItemRangeInserted(0, list.size());
//            }
//        } else {
//            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
//                @Override
//                public int getOldListSize() {
//                    return list.size();
//                }
//
//                @Override
//                public int getNewListSize() {
//                    return data.size();
//                }
//
//                @Override
//                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//                    AnimalTable old = list.get(oldItemPosition);
//                    AnimalTable comment = data.get(newItemPosition);
//                    return Objects.equals(old.getAnimalName(), comment.getAnimalName());
//                }
//
//                @Override
//                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//                    AnimalTable old = list.get(oldItemPosition);
//                    AnimalTable comment = data.get(newItemPosition);
//                    return Objects.equals(old.getAnimalName(), comment.getAnimalName()) && Objects.equals(old.getAnimalType1(), comment.getAnimalType1()) && Objects.equals(old.getAnimalType2(), comment.getAnimalType2()) && Objects.equals(old.getAnimalType3(), comment.getAnimalType3()) && Objects.equals(old.getAnimalType4(), comment.getAnimalType4()) && Objects.equals(old.getAnimalType5(), comment.getAnimalType5()) && Objects.equals(old.getAnimalType6(), comment.getAnimalType6()) && Objects.equals(old.getAnimalType7(), comment.getAnimalType7()) && Objects.equals(old.getAnimalType8(), comment.getAnimalType8()) && Objects.equals(old.getAnimalType9(), comment.getAnimalType9()) && Objects.equals(old.getAnimalType10(), comment.getAnimalType10());
//                }
//            });
//            list = data;
//            diffResult.dispatchUpdatesTo(this);
//        }
//    }
}
