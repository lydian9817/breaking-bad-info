package com.example.breakingbadinfo.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.breakingbadinfo.network.Character
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadinfo.databinding.CharacterNameItemBinding


class CharacterNameAdapter : ListAdapter<Character,
        CharacterNameAdapter.CharacterNameViewHolder>(DiffCallback){

    class CharacterNameViewHolder(private var binding: CharacterNameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(character: Character) {
                binding.character = character
                binding.executePendingBindings()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterNameViewHolder {
        return CharacterNameViewHolder(CharacterNameItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: CharacterNameViewHolder, position: Int) {
        val characterName = getItem(position)
        holder.bind(characterName)
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

}