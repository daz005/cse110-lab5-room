package edu.ucsd.cse110.lab5_room;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.ucsd.cse110.lab5_room.model.db.Note;

public class NotesViewAdapter extends RecyclerView.Adapter<NotesViewAdapter.ViewHolder> {

    private final List<Note> notes;

    public NotesViewAdapter(List<Note> notes){
        super();
        this.notes = notes;
    }

    public NotesViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewAdapter.ViewHolder holder, int position) {
        holder.setNote(notes.get(position));

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView noteTextView;
        private Note note;

        ViewHolder(View itemView) {
            super(itemView);
            this.noteTextView = itemView.findViewById(R.id.notes_row_text);
        }

        public void setNote(Note note) {
            this.note = note;
            this.noteTextView.setText(note.text);
        }
    }
}
