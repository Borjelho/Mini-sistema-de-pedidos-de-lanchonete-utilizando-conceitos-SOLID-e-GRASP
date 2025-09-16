Mini-Serviço de Pedidos (Java)
📌 Objetivo

Implementar, em Java, um mini-serviço para gerenciar pedidos de uma lanchonete.
O serviço permite criar pedidos, adicionar/remover itens, aplicar descontos, realizar pagamentos e finalizar gerando recibo.
O projeto foi desenvolvido com foco na aplicação de padrões GRASP e princípios SOLID.

📖 Contexto

Uma lanchonete precisa registrar seus pedidos.
Cada pedido:

Contém itens;

Pode receber um desconto ativo;

Deve ser pago por uma forma de pagamento selecionada;

Ao ser pago, gera um recibo e envia uma confirmação ao cliente.

✅ Requisitos Funcionais

RF1: Criar pedido

Criar um pedido vazio com identificador único e status ABERTO.

RF2: Adicionar/Remover item

Adicionar item com: produto, preçoUnit, quantidade;

Remover item por id do item.

RF3: Total do pedido

Calcular subtotal = Σ(preçoUnit × qtd);

Calcular total considerando desconto (se houver).

RF4: Desconto (estratégia)

Suportar DescontoPercentual(%) e DescontoValorFixo(R$);

Um pedido pode ter no máximo um desconto ativo.

RF5: Pagamento (estratégia)

Suportar Cartão de Crédito e Pix;

Em caso de sucesso, alterar status do pedido para PAGO.

RF6: Finalizar pedido (recibo)

Gerar recibo textual com: itens, subtotal, desconto, total, forma de pagamento e timestamp.

RF7: Persistência simples

Salvar e recuperar pedidos via repositório em memória (fake).

RF8: Notificação opcional

Após o pagamento, enviar confirmação ao cliente.

🛠 Tecnologias Utilizadas

Java

Padrões GRASP

Princípios SOLID

🚀 Como Executar

Clone este repositório

Compile o projeto com seu ambiente Java

Execute a classe principal para interagir com o serviço

📜 Licença

Projeto desenvolvido para fins acadêmicos.
