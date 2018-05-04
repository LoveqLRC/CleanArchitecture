package com.loveqrc.cleanarchitecture.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loveqrc.cleanarchitecture.R;
import com.loveqrc.cleanarchitecture.model.UserModel;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rc on 2018/5/4.
 * Email:664215432@qq.com
 * Description:
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    public interface OnItemClickListener {
        void onUserItemClicked(UserModel userModel);
    }

    private List<UserModel> mUsersCollection;
    private final LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;

    @Inject
    public UsersAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.row_user, parent, false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        final UserModel userModel = mUsersCollection.get(position);
        holder.textViewTitle.setText(userModel.getFullName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onUserItemClicked(userModel);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mUsersCollection != null ? mUsersCollection.size() : 0;
    }


    public void setUsersCollection(Collection<UserModel> usersCollection) {
        if (usersCollection != null) {
            mUsersCollection = (List<UserModel>) usersCollection;
            notifyDataSetChanged();
        }
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView textViewTitle;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
