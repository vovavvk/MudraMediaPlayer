package il.co.wearabledevices.mudramediaplayer.ui;

import android.support.v7.widget.RecyclerView;
import android.support.wear.widget.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

import il.co.wearabledevices.mudramediaplayer.R;
import il.co.wearabledevices.mudramediaplayer.ui.dummy.AlbumsDummyContent;

/**
 * {@link RecyclerView.Adapter} that can display a {@link AlbumsDummyContent.AlbumsDummyItem} and makes a call to the
 * specified {@link AlbumsFragment.OnAlbumsListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AlbumsAdapter extends WearableRecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    private final List<AlbumsDummyContent.AlbumsDummyItem> mValues;
    private final AlbumsFragment.OnAlbumsListFragmentInteractionListener mListener;


    public AlbumsAdapter(List<AlbumsDummyContent.AlbumsDummyItem> items,
                         AlbumsFragment.OnAlbumsListFragmentInteractionListener listener) {
        //this.setEdgeItemsCenteringEnabled(true);

        mValues = items;
        mListener = listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onAlbumsListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public AlbumsDummyContent.AlbumsDummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.album_id);
            mContentView = (TextView) view.findViewById(R.id.album_content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}