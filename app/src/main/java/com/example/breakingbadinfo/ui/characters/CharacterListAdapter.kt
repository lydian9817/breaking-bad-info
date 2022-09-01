package com.example.breakingbadinfo.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.breakingbadinfo.network.Character
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadinfo.databinding.CharacterNameItemBinding


class CharacterListAdapter(val clickListener: CharacterListener) : ListAdapter<Character,
        CharacterListAdapter.CharacterListViewHolder>(DiffCallback){

    class CharacterListViewHolder(private var binding: CharacterNameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(clickListener: CharacterListener, character: Character) {
                binding.character = character
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
    }

    //checks repeated characters
    companion object DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(CharacterNameItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val characterName = getItem(position)
        holder.bind(clickListener, characterName)
    }
}

class CharacterListener(val clickListener: (character: Character) -> Unit) {
    fun onClick(character: Character) = clickListener(character)
}