package com.example.kotlinadventure

import android.view.View
import kotlinx.android.synthetic.main.activity_game_screen.*


class Story(val gs: GameScreen) {

    var nextPosition1 = "";
    var nextPosition2 = "";
    var nextPosition3 = "";
    var nextPosition4 = "";


    var club = false
    var key = false
    var holySword = false
    var antiMimicPotion = false

    fun selectPosition(position: String?) {
        when (position) {
            "startingPoint" -> startingPoint()
            "room" -> room()
            "slime" -> slime()
            "slimeDefeated" -> slimeDefeated()
            "dead" -> dead()
            "goTitleScreen" -> gs.goTitleScreen()
            "chest" -> chest()
            "club" -> club()
            "mimicChest" -> mimicChest()
            "mimic" -> mimic()
            "mimicIsDead" -> mimicIsDead()
            "bossLairDoor" -> bossLairDoor()
            "noKey" -> noKey()
            "bossLair" -> bossLair()
            "mimicPotion" -> mimicPotion()
            "potion" -> potion()
            "bossFight" -> bossFight()
            "victory" -> victory()
        }
    }

    fun showAllButtons() {
        gs.buttonChoice1.setVisibility(View.VISIBLE)
        gs.buttonChoice2.setVisibility(View.VISIBLE)
        gs.buttonChoice3.setVisibility(View.VISIBLE)
        gs.buttonChoice4.setVisibility(View.VISIBLE)
    }

    fun startingPoint() {
        gs.gameImage.setImageResource(R.drawable.hallway_firstlight)
        gs.choiceInfo.setText("You're met with a long hallway..\n.\nYou can go forward,turn left,turn right or turn back from where you came. ")
        gs.buttonChoice1.setText("Go forward")
        gs.buttonChoice2.setText("Go left")
        gs.buttonChoice3.setText("Go right")
        gs.buttonChoice4.setText("Flee and save yourself")

        showAllButtons()

        nextPosition1 = "room"
        nextPosition2 = "slime"
        nextPosition3 = "chest"
        nextPosition4 = "goTitleScreen"
    }

    fun slime() {
        gs.gameImage.setImageResource(R.drawable.slimelight)
        gs.choiceInfo.setText("You're faced with one of the weakest enemies,but if you're not prepared it could cost your life.\n.\nWill you fight or flee. ")
        gs.buttonChoice1.setText("Fight")
        gs.buttonChoice2.setText("Flee")
        if (club == false) {
            nextPosition1 = "dead"
            nextPosition2 = "startingPoint"
            gs.buttonChoice2.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        } else if (club == true) {
            nextPosition1 = "slimeDefeated"
            nextPosition2 = "startingPoint"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
        if (key == true) {
            gs.gameImage.setImageResource(R.drawable.slime_deadlight)
            gs.choiceInfo.setText("The room is filled only with what is left of the slime.")
            gs.buttonChoice1.setText("Go back")
            nextPosition1 = "startingPoint"
            gs.buttonChoice2.setVisibility(View.INVISIBLE)
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
    }

    fun slimeDefeated() {
        gs.gameImage.setImageResource(R.drawable.keylight)
        gs.choiceInfo.setText("You've defeated the slime..\n.\nIt has dropped a key.It might help you travel further into the dungeon.")
        key = true
        gs.buttonChoice1.setText("Back")
        nextPosition1 = "startingPoint"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun dead() {
        gs.gameImage.setImageResource(R.drawable.deadlight)
        gs.choiceInfo.setText("You were not prepared.\n.\nYou've succumbed to the dungeon.")
        gs.buttonChoice1.setText("Revive")
        nextPosition1 = "goTitleScreen"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun chest() {
        if (club == false) {
            gs.gameImage.setImageResource(R.drawable.chest_closedlight)
            gs.choiceInfo.setText("There is a chest.\n.\nWill you open it")
            gs.buttonChoice1.setText("Open")
            gs.buttonChoice2.setText("Go back")
            nextPosition1 = "club"
            nextPosition2 = "startingPoint"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        } else if (club) {
            gs.gameImage.setImageResource(R.drawable.empty_chestlight)
            gs.choiceInfo.setText("There is nothing in the chest")
            gs.buttonChoice1.setText("Go back")
            nextPosition1 = "startingPoint"
            gs.buttonChoice2.setVisibility(View.INVISIBLE)
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
    }

    fun club() {
        gs.gameImage.setImageResource(R.drawable.clublight)
        gs.choiceInfo.setText("You've found the most basic weapon. .\n.\nMaybe you'll be able to defend yourself.")
        club = true
        gs.buttonChoice1.setText("Go back")
        nextPosition1 = "startingPoint"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun room() {
        gs.gameImage.setImageResource(R.drawable.hallway_secondlight)
        gs.choiceInfo.setText("There is a door in the distance and a room on your right..\n.\nWill you open the door,go back or go right. ")
        showAllButtons()
        gs.buttonChoice1.setText("Open the door")
        gs.buttonChoice2.setText("Go right")
        gs.buttonChoice3.setText("Go back")
        nextPosition1 = "bossLairDoor"
        nextPosition2 = "mimicChest"
        nextPosition3 = "startingPoint"
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun mimicChest() {
        gs.gameImage.setImageResource(R.drawable.chest_closedlight)
        gs.choiceInfo.setText("There is another suspicious chest.\n\nWill you open it or go back. ")
        showAllButtons()
        gs.buttonChoice1.setText("Open it")
        gs.buttonChoice2.setText("Go back")
        nextPosition1 = "mimic"
        nextPosition2 = "room"
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
        if (holySword == true) {
            gs.gameImage.setImageResource(R.drawable.empty_chestlight)
            gs.choiceInfo.setText("You've killed it.There's nothing left to do here")
            gs.buttonChoice1.setText("Back")
            nextPosition1 = "room"
        }
    }

    fun mimic() {
        gs.gameImage.setImageResource(R.drawable.mimiclight)
        gs.choiceInfo.setText("It's a mimic.\n\nFight!\nFlee! ")
        showAllButtons()
        gs.buttonChoice1.setText("Fight!")
        gs.buttonChoice2.setText("Flee!")
        if (antiMimicPotion == false) {
            nextPosition1 = "dead"
            nextPosition2 = "room"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        } else if (antiMimicPotion == true) {
            nextPosition1 = "mimicIsDead"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
    }

    fun mimicIsDead() {
        gs.gameImage.setImageResource(R.drawable.holyswordlight)
        gs.choiceInfo.setText("You've defeated the mimic!You find a 'Master Sword'.\nIt will help you with a tough enemy.")
        holySword = true
        gs.buttonChoice1.setText("Go back!")
        nextPosition1 = "room"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun bossLairDoor() {
        gs.gameImage.setImageResource(R.drawable.door_to_woodlight)
        gs.choiceInfo.setText("The door is locked.\n.\nUnlock it or go back.")
        gs.buttonChoice1.setText("Unlock the door")
        gs.buttonChoice2.setText("Go back")
        showAllButtons()
        if (key == false) {
            nextPosition1 = "noKey"
            nextPosition2 = "room"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        } else if (key == true) {
            nextPosition1 = "bossLair"
            nextPosition2 = "room"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
    }

    fun noKey() {
        gs.gameImage.setImageResource(R.drawable.door_to_woodlight)
        gs.choiceInfo.setText("You don't have a key.")
        gs.buttonChoice1.setText("Go back")
        nextPosition1 = "room"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun bossLair() {
        gs.gameImage.setImageResource(R.drawable.bosslairlight)
        gs.choiceInfo.setText("There are two doors in front of you.You feel a sinister energy behind the left one. ")
        showAllButtons()
        gs.buttonChoice1.setText("Go to the left")
        gs.buttonChoice2.setText("Go to the right")
        gs.buttonChoice3.setText("Go back")
        nextPosition1 = "bossFight"
        nextPosition2 = "mimicPotion"
        nextPosition3 = "room"
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun mimicPotion() {
        gs.gameImage.setImageResource(R.drawable.potionnonemptylight)
        gs.choiceInfo.setText("There is a potion.")
        if (antiMimicPotion == true) {
            gs.gameImage.setImageResource(R.drawable.potionemptylight)
            gs.choiceInfo.setText("There is nothing more to take from this room.")
            gs.buttonChoice1.setText("Back")
            nextPosition1 = "bossLair"
            gs.buttonChoice2.setVisibility(View.INVISIBLE)
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        } else if (antiMimicPotion == false) {
            gs.buttonChoice1.setText("Take a closer look")
            gs.buttonChoice2.setText("Back")
            nextPosition1 = "potion"
            nextPosition2 = "bossLair"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
    }

    fun potion() {
        gs.gameImage.setImageResource(R.drawable.potionlight)
        gs.choiceInfo.setText("The text on the potion states:\nFor when you're faced against a chest full of teeth.")
        antiMimicPotion = true
        gs.buttonChoice1.setText("Back")
        nextPosition1 = "bossLair"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
        gs.buttonChoice3.setVisibility(View.INVISIBLE)
        gs.buttonChoice4.setVisibility(View.INVISIBLE)
    }

    fun bossFight() {
        gs.gameImage.setImageResource(R.drawable.bosslight)
        gs.choiceInfo.setText("There is a powerful black orb.You feel that you can go deeper in to the dungeon if you get past it.")
        gs.buttonChoice1.setText("Fight")
        gs.buttonChoice2.setText("Flee")

        if (holySword == false) {
            nextPosition1 = "dead"
            nextPosition2 = "bossLair"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        } else if (holySword == true) {
            nextPosition1 = "victory"
            nextPosition2 = "bossLair"
            gs.buttonChoice3.setVisibility(View.INVISIBLE)
            gs.buttonChoice4.setVisibility(View.INVISIBLE)
        }
    }

    fun victory() {
        gs.gameImage.setImageResource(R.drawable.congratslight)
        gs.choiceInfo.setText(
            """
            You managed to clear the first floor of the dungeon.
            You continue to venture deeper into it,not knowing what kind of fate awaits you.
            Nonetheless you enjoy a small but sweet victory.
            THE END
            for now....
            """.trimIndent()
        )
        gs.buttonChoice1.setText("Go to start")
        nextPosition1 = "goTitleScreen"
        gs.buttonChoice2.setVisibility(View.INVISIBLE)
    }
}





