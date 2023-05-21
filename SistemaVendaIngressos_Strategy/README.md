## O que são Design Patterns?
Design Patterns, ou Padrões de Projeto, são soluções reutilizáveis para problemas comuns que surgem durante o desenvolvimento de software. Eles são descrições de abordagens e estruturas que podem ser aplicadas para resolver problemas recorrentes de design de software.

***

## Por que é interessante utilizá-los?
Existem várias razões pelas quais é interessante utilizar Design Patterns:

### Reutilização de soluções:   

    Os Design Patterns oferecem soluções testadas e comprovadas para problemas comuns. Ao aplicar um Design Pattern, você pode economizar tempo e esforço, pois não precisa reinventar a roda toda vez que encontrar um problema semelhante.

### Comunicação efetiva: 

    Os Design Patterns fornecem uma terminologia comum que os desenvolvedores podem usar para discutir soluções de design. Isso facilita a comunicação entre membros da equipe e melhora a compreensão do código.

### Melhoria da manutenibilidade: 

    Os Design Patterns promovem o desenvolvimento de um código mais modular e de fácil manutenção. Eles ajudam a separar preocupações, tornando as alterações mais localizadas e menos propensas a introduzir erros em outras partes do sistema.

***

## Quais são os tipos de Design Patterns?

<br>

### Existem vários tipos de Design Patterns, sendo os principais:

<br>

### Padrões de criação (Creational Patterns): 

<br>
Esses padrões lidam com a criação de objetos de maneira adequada às circunstâncias.
<br> 
Exemplo: Singleton.

<br>
O padrão Singleton é utilizado quando é necessário garantir que uma classe tenha apenas uma única instância em todo o sistema. Isso é útil em situações em que existe um recurso compartilhado que precisa ser acessado por várias partes do código. O Singleton permite que você controle o acesso a esse recurso, evitando a criação de múltiplas instâncias desnecessárias. Além disso, ele fornece um ponto centralizado de acesso, facilitando a coordenação e o gerenciamento desse recurso.
<br>

### Exemplo de Implementação:

<br>

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
     // Instância única da conexão com o banco de dados

    private DatabaseConnection() {
    // Construtor privado para impedir a criação de instâncias externas
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        // Lógica para conectar ao banco de dados
        System.out.println("Conectado ao banco de dados.");
    }

    public void disconnect() {
        // Lógica para desconectar do banco de dados
        System.out.println("Desconectado do banco de dados.");
    }
}
```

Neste exemplo, a classe DatabaseConnection utiliza o padrão Singleton para garantir que exista apenas uma única instância da conexão com o banco de dados em todo o sistema. O construtor é definido como privado para evitar a criação de instâncias externas. O método getInstance() retorna a única instância existente, criando-a apenas se ainda não foi criada. Isso garante que todas as partes do código que precisam da conexão com o banco de dados obtenham a mesma instância, evitando duplicações e inconsistências.

***



### Padrões estruturais (Structural Patterns): 
<br>
Esses padrões lidam com a composição de classes e objetos para formar estruturas maiores. 
<br>
Exemplo: Decorator.

<br>
O padrão Decorator é usado quando você precisa adicionar comportamentos adicionais a um objeto de forma dinâmica, sem alterar sua estrutura básica. Ele permite estender as funcionalidades de um objeto sem modificar suas classes ou herança. Isso é útil quando você deseja adicionar funcionalidades extras a um objeto existente de maneira flexível, evitando a criação de várias subclasses para cada combinação possível de funcionalidades. O Decorator promove a modularidade e a flexibilidade, permitindo que você componha objetos com diferentes comportamentos em tempo de execução.
<br>

<br>

### Exemplo de Implementação:
<br>

Neste exemplo, temos a interface Pizza que define a funcionalidade básica de uma pizza. 
```java
// Interface que define a funcionalidade básica do componente
public interface Pizza {
    String getDescription();
    double getCost();
}

```
<br>

A classe PizzaMargherita é uma implementação concreta dessa interface.
```java
// Implementação concreta do componente
public class PizzaMargherita implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza Margherita";
    }

    @Override
    public double getCost() {
        return 8.99;
    }
}
```

<br>

A classe abstrata PizzaDecorator serve como base para os decoradores concretos. Ela contém uma referência ao componente original, representado pela interface Pizza, e delega chamadas de métodos para esse componente.
```java
// Decorator abstrato que serve de base para os decoradores concretos
public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
```

<br>

Os decoradores concretos, como ExtraCheeseDecorator e PepperoniDecorator, estendem a classe PizzaDecorator e adicionam funcionalidades extras à pizza. Eles modificam a descrição e o custo da pizza base, adicionando ingredientes extras.
```java
// Decorador concreto que adiciona ingredientes extras à pizza
public class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}
```
```java
// Decorador concreto que adiciona pepperoni à pizza
public class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}
```

<br>

Dessa forma, podemos criar pizzas personalizadas combinando diferentes decoradores. Por exemplo:

```java
Pizza pizza = new PizzaMargherita();
pizza = new ExtraCheeseDecorator(pizza);
pizza = new PepperoniDecorator(pizza);

System.out.println(pizza.getDescription());  // Output: Pizza Margherita, Extra Cheese, Pepperoni
System.out.println(pizza.getCost());  // Output: 12.49
```
Neste caso, criamos uma pizza Margherita e adicionamos queijo extra e pepperoni. A descrição resultante é "Pizza Margherita, Extra Cheese, Pepperoni" e o custo é 12.49.

<br>

***

<br>

### Padrões comportamentais (Behavioral Patterns): 
<br>
Esses padrões estão relacionados ao comportamento de objetos e a comunicação entre eles. 
<br>
Exemplo: Observer.

<br>

O padrão Observer é utilizado quando há uma relação de dependência entre objetos, onde a alteração de um objeto requer atualizações em outros objetos dependentes. O Observer permite que os objetos observadores sejam notificados automaticamente quando o estado do objeto observado é alterado. Isso é útil em cenários onde há acoplamento fraco entre os objetos e quando você precisa manter a consistência e sincronização entre eles. O Observer facilita a comunicação e a interação entre objetos, permitindo que eles sejam atualizados de forma independente e reativa às mudanças.

<br>

### Exemplo de Implementação:

<br>
Neste exemplo, temos a interface Observer, que define o método update() que será implementado pelos observadores concretos.

```java
// Interface do observador
interface Observer {
    void update(String message);
}
```
<br>
 A classe ConcreteObserver é uma implementação concreta dessa interface, onde cada observador possui um nome.

```java
// Classe concreta do observador
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu a mensagem: " + message);
    }
}
```

<br>
A classe Subject é o objeto que está sendo observado. Ela mantém uma lista de observadores e possui métodos para adicionar (attach()) e remover (detach()) observadores. O método setMessage() atualiza a mensagem do objeto observado e notifica todos os observadores registrados chamando o método update() em cada um deles.

```java
// Classe do assunto (ou sujeito observado)
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```

<br>
Podemos testar esse exemplo da seguinte forma:

```java
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        subject.setMessage("Nova mensagem!");
        subject.detach(observer2);

        subject.setMessage("Outra mensagem!");
    }
}
```

<br>
Neste exemplo, criamos três observadores (observer1, observer2 e observer3) e os registramos no objeto subject usando o método attach(). Em seguida, definimos uma mensagem para o subject usando setMessage(). Todos os observadores registrados serão notificados e a mensagem será exibida.

Em seguida, usamos detach() para remover o observer2 da lista de observadores. Assim, quando definimos uma nova mensagem com setMessage(), apenas observer1 e observer3 serão notificados.

A saída esperada será:

    Observer 1 recebeu a mensagem: Nova mensagem!
    Observer 2 recebeu a mensagem: Nova mensagem!
    Observer 3 recebeu a mensagem: Nova mensagem!
    Observer 1 recebeu a mensagem: Outra mensagem!
    Observer 3 recebeu a mensagem: Outra mensagem!

<br> 
