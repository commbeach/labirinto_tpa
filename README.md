<h1>Labirinto com Animação</h1>
Este projeto é uma implementação de um labirinto em Java utilizando a biblioteca Swing para criar uma interface gráfica. Foi desenvolvido como parte do exercício da disciplina de Técnicas de Programação Avançada no segundo semestre de 2024.

<h2>Descrição</h2>
O programa cria uma representação gráfica de um labirinto, onde as células do labirinto são representadas por painéis de cores diferentes. Células que representam paredes são exibidas em preto e as passagens em branco. O "jogador" é representado por uma célula vermelha e pode se mover pelo labirinto a partir de uma posição inicial definida.

<h2>Funcionalidades</h2>
<p><b>Criação de Labirinto:</b> O labirinto é gerado a partir de um arquivo CSV, que define as posições das paredes e passagens.</p>
<p><b>Movimentação do Jogador:</b> O jogador se move pelo labirinto em busca da saída, sendo animado por meio da troca de cores nas células.</p>
<p><b>Verificação de Caminhos:</b> O algoritmo tenta encontrar um caminho até a saída utilizando uma abordagem recursiva.</p>

<h2>Tecnologias Utilizadas</h2>
<p><b>Java:</b> A linguagem de programação principal utilizada.</p>
<p><b>Swing:</b> Para a construção da interface gráfica.</p>
<p><b>CSVReader:</b> Para leitura do arquivo CSV que define o labirinto.</p>
