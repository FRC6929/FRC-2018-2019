extends Control

var choosedElementP1 = 0
var choosedElementP2 = 0
var p2Ready = false
var p1Ready = false


var RockP1Texture
var PaperP1Texture
var ScissorsP1Texture

var RockP2Texture
var PaperP2Texture
var ScissorsP2Texture

var gameOverScreen

onready var spellCardRockP1AP = get_node("PanelP1/RockP1/SpellCard/AttackPower")
onready var spellCardRockP1Title = get_node("PanelP1/RockP1/SpellCard/Title")
onready var spellCardRockP1Desc = get_node("PanelP1/RockP1/SpellCard/Description")

onready var spellCardPaperP1AP = get_node("PanelP1/PaperP1/SpellCard/AttackPower")
onready var spellCardPaperP1Title = get_node("PanelP1/PaperP1/SpellCard/Title")
onready var spellCardPaperP1Desc = get_node("PanelP1/PaperP1/SpellCard/Description")

onready var spellCardScissorsP1AP = get_node("PanelP1/ScissorsP1/SpellCard/AttackPower")
onready var spellCardScissorsP1Title = get_node("PanelP1/ScissorsP1/SpellCard/Title")
onready var spellCardScissorsP1Desc = get_node("PanelP1/ScissorsP1/SpellCard/Description")


onready var spellCardRockP2AP = get_node("PanelP2/RockP2/SpellCard/AttackPower")
onready var spellCardRockP2Title = get_node("PanelP2/RockP2/SpellCard/Title")
onready var spellCardRockP2Desc = get_node("PanelP2/RockP2/SpellCard/Description")

onready var spellCardPaperP2AP = get_node("PanelP2/PaperP2/SpellCard/AttackPower")
onready var spellCardPaperP2Title = get_node("PanelP2/PaperP2/SpellCard/Title")
onready var spellCardPaperP2Desc = get_node("PanelP2/PaperP2/SpellCard/Description")

onready var spellCardScissorsP2AP = get_node("PanelP2/ScissorsP2/SpellCard/AttackPower")
onready var spellCardScissorsP2Title = get_node("PanelP2/ScissorsP2/SpellCard/Title")
onready var spellCardScissorsP2Desc = get_node("PanelP2/ScissorsP2/SpellCard/Description")

var AINode
var AIPath

func _ready():
	gameOverScreen = get_node("Panel3")
	AI_DATA.lastSpellPlayed = 0
	AI_DATA.paperSpellPlayedNumber = 0
	AI_DATA.rockSpellPlayedNumber = 0
	AI_DATA.scissorsSpellPlayedNumber = 0
	gameOverScreen.hide()
	
	gameManager.lifeP1 = 20
	gameManager.lifeP2 = 20
	
	RockP1Texture = get_node("PanelP1/AttackIndicatorP1/RockP1Texture")
	PaperP1Texture = get_node("PanelP1/AttackIndicatorP1/PaperP1Texture")
	ScissorsP1Texture = get_node("PanelP1/AttackIndicatorP1/ScissorsP1Texture")
	
	RockP2Texture = get_node("PanelP2/AttackIndicatorP2/RockP2Texture")
	PaperP2Texture = get_node("PanelP2/AttackIndicatorP2/PaperP2Texture")
	ScissorsP2Texture = get_node("PanelP2/AttackIndicatorP2/ScissorsP2Texture")
	
	
	spellCardRockP1AP.text = str(gameManager.powerlistP1[0].call_func(true)[0])
	spellCardRockP1Title.text = gameManager.powerlistP1[0].call_func(true)[1]
	spellCardRockP1Desc.text = gameManager.powerlistP1[0].call_func(true)[2]
	
	spellCardPaperP1AP.text = str(gameManager.powerlistP1[3].call_func(true)[0])
	spellCardPaperP1Title.text = gameManager.powerlistP1[3].call_func(true)[1]
	spellCardPaperP1Desc.text = gameManager.powerlistP1[3].call_func(true)[2]
	
	spellCardScissorsP1AP.text = str(gameManager.powerlistP1[6].call_func(true)[0])
	spellCardScissorsP1Title.text = str(gameManager.powerlistP1[6].call_func(true)[1])
	spellCardScissorsP1Desc.text = str(gameManager.powerlistP1[6].call_func(true)[2])
	
	
	
	spellCardRockP2AP.text = str(gameManager.powerlistP2[0].call_func(true)[0])
	spellCardRockP2Title.text = gameManager.powerlistP2[0].call_func(true)[1]
	spellCardRockP2Desc.text = gameManager.powerlistP2[0].call_func(true)[2]
	
	spellCardPaperP2AP.text = str(gameManager.powerlistP2[3].call_func(true)[0])
	spellCardPaperP2Title.text = gameManager.powerlistP2[3].call_func(true)[1]
	spellCardPaperP2Desc.text = gameManager.powerlistP2[3].call_func(true)[2]
	
	spellCardScissorsP2AP.text = str(gameManager.powerlistP2[6].call_func(true)[0])
	spellCardScissorsP2Title.text = str(gameManager.powerlistP2[6].call_func(true)[1])
	spellCardScissorsP2Desc.text = str(gameManager.powerlistP2[6].call_func(true)[2])
	
	
	
	RockP1Texture.hide()
	PaperP1Texture.hide()
	ScissorsP1Texture.hide()
	
	RockP2Texture.hide()
	PaperP2Texture.hide()
	ScissorsP2Texture.hide()

	
	get_node("PanelLifeP2/lifeCounterP2").text = str(gameManager.lifeP2)
	get_node("PanelLifeP1/lifeCounterP1").text = str(gameManager.lifeP1)
	
	set_process(true)


func _process(delta):
	if Input.is_action_just_pressed("p1_Rock"):
		choosedElementP1 = 1
		RockP1Texture.hide()
		PaperP1Texture.hide()
		ScissorsP1Texture.hide()
		p1Ready = true
	if Input.is_action_just_pressed("p1_Paper"):
		choosedElementP1 = 2
		RockP1Texture.hide()
		PaperP1Texture.hide()
		ScissorsP1Texture.hide()
		p1Ready = true
	if Input.is_action_just_pressed("p1_Scissors"):
		choosedElementP1 = 3
		RockP1Texture.hide()
		PaperP1Texture.hide()
		ScissorsP1Texture.hide()
		p1Ready = true
	
	
	
	if p1Ready:
		gameManager.p1PowerType = choosedElementP1
		choosedElementP2 = AINode.selectSpell()
		gameManager.p2PowerType = choosedElementP2
		
		#Faire Choisir AI ici
		
		if choosedElementP1 == 1:
			RockP1Texture.show()
		elif choosedElementP1 == 2:
			PaperP1Texture.show()
		elif choosedElementP1 == 3:
			ScissorsP1Texture.show()
		
		if choosedElementP2 == 1:
			RockP2Texture.show()
			ScissorsP2Texture.hide()
			PaperP2Texture.hide()
		elif choosedElementP2 == 2:
			PaperP2Texture.show()
			RockP2Texture.hide()
			ScissorsP2Texture.hide()
		elif choosedElementP2 == 3:
			ScissorsP2Texture.show()
			PaperP2Texture.hide()
			RockP2Texture.hide()
		
		
		gameManager.processAttack()
		
		AI_DATA.lastSpellPlayed = choosedElementP1
		
		if choosedElementP1 == 1:
			AI_DATA.rockSpellPlayedNumber += 1
		elif choosedElementP1 == 2:
			AI_DATA.paperSpellPlayedNumber += 1
		elif choosedElementP1 == 3:
			AI_DATA.scissorsSpellPlayedNumber += 1
		
		get_node("PanelLifeP2/lifeCounterP2").text = str(gameManager.lifeP2)
		get_node("PanelLifeP1/lifeCounterP1").text = str(gameManager.lifeP1)
		p2Ready = false
		p1Ready = false
		
		if gameManager.lifeP1 <= 0 && gameManager.lifeP2 >= 0:
			gameOverScreen.show()
		elif gameManager.lifeP1 >= 0 && gameManager.lifeP2 <= 0:
			gameOverScreen.show()
		elif gameManager.lifeP1 <= 0 && gameManager.lifeP2 <= 0:
			gameOverScreen.show()
			
			
		if choosedElementP1 == 1:
			spellCardRockP1AP.text = str(gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[0])
			spellCardRockP1Title.text = gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[1]
			spellCardRockP1Desc.text = gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[2]
		elif choosedElementP1 == 2:
			spellCardPaperP1AP.text = str(gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[0])
			spellCardPaperP1Title.text = gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[1]
			spellCardPaperP1Desc.text = gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[2]
		elif choosedElementP1 == 3:
			spellCardScissorsP1AP.text = str(gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[0])
			spellCardScissorsP1Title.text = str(gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[1])
			spellCardScissorsP1Desc.text = str(gameManager.powerlistP1[gameManager.spellIndexP1].call_func(true)[2])
	
		if choosedElementP2 == 1:
			spellCardRockP2AP.text = str(gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[0])
			spellCardRockP2Title.text = gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[1]
			spellCardRockP2Desc.text = gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[2]
		if choosedElementP2 == 2:
			spellCardPaperP2AP.text = str(gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[0])
			spellCardPaperP2Title.text = gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[1]
			spellCardPaperP2Desc.text = gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[2]
		if choosedElementP2 == 3:
			spellCardScissorsP2AP.text = str(gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[0])
			spellCardScissorsP2Title.text = str(gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[1])
			spellCardScissorsP2Desc.text = str(gameManager.powerlistP2[gameManager.spellIndexP2].call_func(true)[2])
	

func _on_RockP1Button_pressed():
	choosedElementP1 = 1
	RockP1Texture.hide()
	PaperP1Texture.hide()
	ScissorsP1Texture.hide()
	p1Ready = true



func _on_restartButton_pressed():
	get_tree().reload_current_scene()
	

func get_AI_Node():
	AINode = get_node(AIPath)

func _on_PaperP1Button_pressed():
	choosedElementP1 = 2
	RockP1Texture.hide()
	PaperP1Texture.hide()
	ScissorsP1Texture.hide()
	p1Ready = true



func _on_ScissorsP1Button_pressed():
	choosedElementP1 = 3
	RockP1Texture.hide()
	PaperP1Texture.hide()
	ScissorsP1Texture.hide()
	p1Ready = true
