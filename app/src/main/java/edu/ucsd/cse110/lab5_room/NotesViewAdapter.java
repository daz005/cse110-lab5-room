package edu.ucsd.cse110.lab5_room;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.function.Consumer;

import edu.ucsd.cse110.lab5_room.model.db.Note;

public class NotesViewAdapter extends RecyclerView.Adapter<NotesViewAdapter.ViewHolder> {

    private final List<Note> notes;
    private final Consumer<Note> onNoteRemoved;


    public NotesViewAdapter(List<Note> notes, Consumer<Note> onNoteRemoved){
        super();
        this.notes = notes;
        this.onNoteRemoved = onNoteRemoved;
    }

    public NotesViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_row, parent, false);

        return new ViewHolder(view, this::removeNote, onNoteRemoved);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewAdapter.ViewHolder holder, int position) {
        holder.setNote(notes.get(position));

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }



    public void addNote(Note note){

        this.notes.add(note);
        this.notifyItemChanged(this.notes.size()-1);
    }

    public void removeNote(int position){
        this.notes.remove(position);
        this.notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView noteTextView;
        private Note note;

        ViewHolder(View itemView, Consumer<Integer> removeNote, Consumer<Note> onNoteRemoved) {
            super(itemView);
            this.noteTextView = itemView.findViewById(R.id.notes_row_text);
            Button removeBtn = itemView.findViewById(R.id.remove_note_button);
            removeBtn.setOnClickListener((view) ->{
                removeNote.accept(this.getAdapterPosition());
                onNoteRemoved.accept(note);
            });

        }

        public void setNote(Note note) {
            this.note = note;
            this.noteTextView.setText(note.text);
        }
    }
}
