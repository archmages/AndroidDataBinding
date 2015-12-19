package archmages.github.databindingsamples.listitem;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import archmages.github.databindingsamples.BR;
import archmages.github.databindingsamples.R;
import archmages.github.databindingsamples.model.User;
import archmages.github.databindingsamples.utils.RandomUtil;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:lmyu@wisorg.com">David.Yu</a>
 * @version V1.0, 16/12/15
 */
public class UserAdapter extends BaseAdapter {

    private List<User> users;

    public UserAdapter() {
        users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("张", "" + i));
        }
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return users.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.user_list_item_view, viewGroup, false);
        binding.setVariable(BR.user, users.get(i));
        binding.setVariable(BR.imageUrl, RandomUtil.nextImgUrl());
        Picasso.with(viewGroup.getContext()).load(RandomUtil.nextImgUrl())
                .error(viewGroup.getContext().getDrawable(R.drawable.error))
                .into(((ImageView) binding.getRoot().findViewById(R.id.ivAvatar)));
        binding.executePendingBindings();
        return binding.getRoot();
    }

//    @BindingAdapter({"bind:imageUrl", "bind:error"})
//    public static void loadImage(ImageView view, String url, Drawable error) {
//        Log.d("ylm", url);
//        Picasso.with(view.getContext()).load(url).error(error).into(view);
//    }
}
