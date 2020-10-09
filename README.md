# Monster Battle using Threads

Em um jogo online, diversos personagens se unem para derrotar um monstro cuja a vida é 1000. Cada personagem tira um pouco da vida do monstro com seus golpes. Abaixo segue a lista de personagens e o poder dos seus golpes:</br>

> Personagem 1 – golpe valor aleatório entre 1-10;</br>
> Personagem 2 – golpe valor aleatório entre 5-30;</br>
> Personagem 3 – golpe valor aleatório entre 20-27;</br>
> Personagem 4 – golpe valor aleatório entre 6-19;</br>
> Personagem 5 – golpe valor aleatório entre 2-13;</br>

O programa concorrente em Java, simula esta batalha assumindo que só um personagem por vez pode diminuir a vida do monstro. Quando o monstro é derrotado, é exibido o personagem que derrotou o monstro (o que deu o golpe que deixou a vida do monstro chegar em 0 ou menos que isto), o personagem que mais contribuiu para derrotar o monstro (que mais diminuiu a vida do monstro) e o que menos contribuiu para derrotar o monstro (que menos diminuiu a vida do monstro).</br>
*O monstro se regenera aleatoriamente quando sua vida fica menor que 30% do valor original.
