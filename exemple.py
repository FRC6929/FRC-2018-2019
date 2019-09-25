#Fonctions Simples
def fonction1():
	print("Salut")


def fonction2():
	print("ça va?")
	

def fonction3():
	print("Au revoir")

listeDeFonctions = [fonction1,fonction2,fonction3]
fonctionÀLancer = int(input("Veuillez entrer l'index de la fonction à lancer : "))

listeDeFonctions[fonctionÀLancer]()


#Fonctions plus avancées

def Banane(isCuit):
    if isCuit == True:
        ingrédients = ["banane", "feu"]
        return ingrédients
    else :
        ingrédients = ["banane", "citron"]
        return ingrédients 

def Jambon(isCuit):
    if isCuit == True:
        ingrédients = ["jambon", "feu"]
        return ingrédients
    else :
        ingrédients = ["jambon", "moutard"]
        return ingrédients 

def Baloney(isCuit):
    if isCuit == True:
        ingrédients = ["baloney", "feu"]
        return ingrédients
    else :
        ingrédients = ["baloney", "piment"]
        return ingrédients 

listDeFonctions = [Banane, Jambon, Baloney]
fonctionÀLancer = int(input("Veuillez entrer l'index de la fonction à lancer : "))

ingrédient = listDeFonctions[fonctionÀLancer](True)[1]
print(ingrédient)
